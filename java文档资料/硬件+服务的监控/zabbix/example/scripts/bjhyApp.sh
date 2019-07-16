#!/bin/bash
#
#用于管理java应用
#bjhyApp.sh [start|stop|restart|status]
#2019-05-18 
#

runapp(){
    logFile="/opt/scripts/app.log"
    # 保存上一个服务启动结果：0表示未启动，1表示已启动
    check_run=0
    app_name=$1
    app_port=$2
    
    echo "`date "+%F %T"` 正在等待应用程序 ${app_name} 启动成功" | tee -a ${logFile}

    sudo service ${app_name} start

    app_pid=""
    count=0
    while [ -z "${app_pid}" ]
    do
        if [ ${count} -eq 60 ];then
            echo "`date '+%F %T'` 应用程序 ${app_name} 在5分钟内没有监听到进程pid，自动跳出监听程序，避免脚本死循环执行..." | tee -a ${logFile}
            exit 1;
        fi
        count=`expr ${count} + 1`
        sleep 5
        
        app_pid=`sudo netstat -nap| grep 'LISTEN'| grep ${app_port}| awk '{printf $7}'| cut -d/ -f1`
        echo "`date '+%F %T'` ------pid:${app_pid}------times:${count}------port:${app_port}" | tee -a ${logFile}
    done
    
    #sleep 5
    # 保存上一个服务启动结果：0表示未启动，1表示已启动
    check_run=1
    echo "`date '+%F %T'` 应用程序 ${app_name} 启动成功，进程号pid=${app_pid}，端口port=${app_port}" | tee -a ${logFile}
    
}

start(){
    #睡眠10秒等待中间件服务先启动
    sleep 10

    #静态文件服务
    runapp ares-api-provider 20993
    
    if [ ${check_run} -eq 1 ];then
        #日志服务
        runapp hephaestus-api-provider 20882
    fi
    
    if [ ${check_run} -eq 1 ];then
        #附件接口服务
        runapp show-attach-provider 6696
    fi
    
    if [ ${check_run} -eq 1 ];then
        #附件服务
        runapp show-attach-provider-web 6691
    fi
    
    if [ ${check_run} -eq 1 ];then
        #附件测试
        runapp show-attach-test 6695
    fi
    
    if [ ${check_run} -eq 1 ];then
        #平台接口服务
        runapp poseidon-api-provider 20980
    fi
    
    if [ ${check_run} -eq 1 ];then
        #平台服务
        runapp poseidon-web 8085
    fi
    
    if [ ${check_run} -eq 1 ];then
        #流程接口服务
        runapp carpo-api-provider 20891
    fi
    
    if [ ${check_run} -eq 1 ];then
        #流程服务
        runapp carpo-web 8088
    fi
    
    if [ ${check_run} -eq 1 ];then
        #警务人事接口服务
        runapp police-personnel-api-provider 6660
    fi
    
    if [ ${check_run} -eq 1 ];then
        #警务人事服务
        runapp police-personnel-build 8113
    fi
    
    if [ ${check_run} -eq 1 ];then
        #警务督察服务
        runapp police_affair-build 8116
    fi
    
    if [ ${check_run} -eq 1 ];then
        #ebmp服务
        runapp ebmp 9911
    fi
    
    status
}

stop(){
    sudo service ares-api-provider stop
    sudo service hephaestus-api-provider stop
    sudo service show-attach-provider stop
    sudo service show-attach-provider-web stop
    sudo service show-attach-test stop
    sudo service poseidon-api-provider stop
    sudo service poseidon-web stop
    sudo service carpo-api-provider stop
    sudo service carpo-web stop
    sudo service police-personnel-api-provider stop
    sudo service police-personnel-build stop
    sudo service police_affair-build stop
    sudo service ebmp stop
}

status(){
    sudo service ares-api-provider status
    sudo service hephaestus-api-provider status
    sudo service show-attach-provider status
    sudo service show-attach-provider-web status
    sudo service show-attach-test status
    sudo service poseidon-api-provider status
    sudo service poseidon-web status
    sudo service carpo-api-provider status
    sudo service carpo-web status
    sudo service police-personnel-api-provider status
    sudo service police-personnel-build status
    sudo service police_affair-build status
    sudo service ebmp status
}

restart(){
    stop
    sleep 1
    start
}


action=$1

# 保存上一个服务启动结果：0表示未启动，1表示已启动
check_run=0

case ${action} in
    "start")
        start
        ;;
    "stop")
        stop
        ;;
    "restart")
        restart
        ;;
    "status")
        status
        ;;
    *)
        echo "Useage: $0 [start|stop|restart|status]"
        ;;
esac

