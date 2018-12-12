#! /bin/bash
#应用程序的名称
app_name=poseidon-api-provider
# 查找端口号 20980 对应的进程
port=20980
# 得到当前目录
curr_dir=$(cd `dirname $0`; pwd)
echo 批处理命令当前目录 $curr_dir
pid=$(netstat -anp|grep 'LISTEN'|grep $port|awk '{printf $7}'|cut -d/ -f1)
# 如果pid不为空则就杀死进程
if [ -n "$pid" ];then
   kill -9 $pid
   echo 端口:$port对应的进程 $pid被杀死...
fi
echo 正在启动 $app_name 服务,请稍后...
# 将pid设置为空
pid=""
count=0
./$app_name/start.sh
# 若 进程pid为空,则监听pid
while [ -z "$pid" ]
do
  if [ $count -eq 60 ];then
     echo 应用程序 $app_name 在5分钟内没有监听到进程pid,自动跳出监听程序,避免脚本死循环执行...
     break;
  fi
  count=`expr $count + 1`
  sleep 5
  pid=$(netstat -anp|grep 'LISTEN'|grep $port|awk '{printf $7}'|cut -d/ -f1)
done
# 等待 10s ,以保证dubbo服务注册成功
sleep 10
echo 应用程序 $app_name 启动成功,进程pid=$pid
echo ==============================================================================
#应用程序的名称
app_name=poseidon-web
# 查找端口号 8085 对应的进程
port=8085
pid=$(netstat -anp|grep 'LISTEN'|grep $port|awk '{printf $7}'|cut -d/ -f1)
# 如果pid不为空则就杀死进程
if [ -n "$pid" ];then
   kill -9 $pid
   echo 端口:$port对应的进程 $pid被杀死...
fi
echo 正在启动 $app_name 服务,请稍后...
# 将pid设置为空
pid=""
count=0
./$app_name/start.sh
# 若 进程pid为空,则监听pid
while [ -z "$pid" ]
do
  if [ $count -eq 60 ];then
     echo 应用程序 $app_name 在5分钟内没有监听到进程pid,自动跳出监听程序,避免脚本死循环执行...
     break;
  fi
  count=`expr $count + 1`
  sleep 5
  pid=$(netstat -anp|grep 'LISTEN'|grep $port|awk '{printf $7}'|cut -d/ -f1)
done
# 等待15s,以保证web服务启动成功
sleep 15
echo 应用程序 $app_name 启动成功,进程pid=$pid


