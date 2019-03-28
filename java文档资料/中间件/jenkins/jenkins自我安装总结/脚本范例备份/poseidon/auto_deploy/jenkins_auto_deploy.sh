#! /bin/bash
# 运行命令 ./xx.sh project-demo 7980
# 得到当前目录
curr_dir=$(cd `dirname $0`; pwd)

# 应用程序名称
app_name=$1

# 应用程序执行命令
exec_commend=install

# 应用程序的端口号
app_port=$2

# 应用程序的进程pid
app_pid=""
# 应用程序目录名称
app_dir_name=$app_name

#临时传输的拷贝目录名称
temp_transfer_app_dir_name=$app_name-transfer

# 应用程序目录
app_dir=$curr_dir/$app_dir_name

# 临时传输的拷贝目录
temp_transfer_app_dir=$curr_dir/$temp_transfer_app_dir_name

#打包的模块名称
package_module_name=$3

#打包的jar名称
package_jar_name=$4

# 用户和用户组
user=jenkins
group=jenkins

# ==============================函数执行区=======================================
# 处理临时传输目录,使其规范化
dealWithTempTransferDir(){
    if [ -d "$temp_transfer_app_dir/$package_module_name" ]; then
       sudo  mv $temp_transfer_app_dir/$package_module_name/target/$package_jar_name.jar $temp_transfer_app_dir
       sudo  rm -rf $temp_transfer_app_dir/$package_module_name
	   
	   # 判断package_jar_name 与 app_name 是否相等,
	   # 若不相等,则将temp_transfer_app_dir目录下的package_jar_name.jar和package_jar_name.conf更名为app_name.jar和app_name.conf
	   if [ $package_jar_name != $app_name ]; then
			sudo mv $temp_transfer_app_dir/$package_jar_name.jar $temp_transfer_app_dir/$app_name.jar
			sudo mv $temp_transfer_app_dir/$package_jar_name.conf $temp_transfer_app_dir/$app_name.conf
	   fi
	   
       echo  "-----临时传输目录处理完毕!"
	else
	   echo  "-----$temp_transfer_app_dir/$package_module_name临时目录处理失败,相关路径不存在!"
    fi

}

# 从临时传输文件目录中拷贝应用
copyApp(){
    # 处理临时传输目录,使其规范化
    dealWithTempTransferDir

    # 删除应用程序目录
    sudo rm -rf $app_dir
    #判断引用程序目录是否存在
    if [ ! -d "$app_dir" ]; then
      sudo mkdir $app_dir
      sudo cp -f -r $temp_transfer_app_dir/* $app_dir
      # 授予创建目录的执行权限
      sudo chmod -R 755 $app_dir
      checkUserAndGroupExist
      echo -----目录创建成功,并成功拷贝数据.
    else
      echo -----应用程序目录删除失败:$app_dir
      exit 1
    fi
    # 删除临时传输目录
    # sudo rm -rf $temp_transfer_app_dir

}

# 检测用户及用户组是否创建
checkUserAndGroupExist(){
	# exist状态,0:表示已经存在,1:表示不存在
	# 检测用户组是否存在,不存在则进行创建
	egrep "^$group" /etc/group >& /dev/null
	group_exist=$?

	# 检测用户是否存在,不存在则进行创建
	egrep "^$user" /etc/passwd >& /dev/null
	user_exist=$?
    echo "----------------------------$group_exist-------$user_exist"
	
	if [ $group_exist -eq 0 ] && [ $user_exist -eq 0 ]; then

	   # 设置启动用户的目录权限
	   echo "设置启动用户的目录权限"
	   sudo chown -R $user:$group $app_dir
	fi
}

# 启动应用
startApp(){
    echo "开始服务 '$app_name'"

    # 开始服务
    sudo su - $user -c "sudo service $app_name start"
   
    echo "正在等待服务启动成功"
    app_pid=""
    count=0
    # 若 进程pid为空,则监听pid
    while [ -z "$app_pid" ]
    do
      if [ $count -eq 60 ];then
         echo 应用程序 $app_name 在5分钟内没有监听到进程pid,自动跳出监听程序,避免脚本死循环执行...
         break;
      fi
      count=`expr $count + 1`
      sleep 5
	  # 此处可以改进为通过进程号获取端口号来监听...
      app_pid=$(sudo netstat -anp|grep 'LISTEN'|grep $app_port|awk '{printf $7}'|cut -d/ -f1)
      echo ---------$app_pid --------------$count -------port:$app_port
    done

    #等待15秒,包服务启动成功
    sleep 15
    echo "应用程序$app_name启动成功,进程pid=$app_pid"
}


# 安装应用
installApp(){
    copyApp
    echo "-----正在安装应用app_name=$app_name"

    # 检测要安装的应用是否存在,不存在则退出安装
    if [ ! -f "$app_dir/$app_name.jar" ]; then
        echo "没有找到$app_name.jar在目录$app_dir下"
        exit 1
    fi

    if [ ! -f "$app_dir/config/application.yml" ]; then
        if [ ! -f "$app_dir/config/application.properties" ]; then
			echo "没有找到application.yml 和 application.properties 在目录$app_dir/config"
			exit 1
		fi
    fi

    # 开始安装用户和组
    echo "正在检测安装用户和组是否存在,不存在则进行创建"

    # 检测用户组是否存在,不存在则进行创建
    egrep "^$group" /etc/group >& /dev/null
    if [ $? -ne 0 ]; then
        echo "创建用户组开始"
       sudo groupadd $group
        echo "创建用户组结束"
    fi

    # 检测用户是否存在,不存在则进行创建
    egrep "^$user" /etc/passwd >& /dev/null
    if [ $? -ne 0 ]; then
        echo "创建用户开始"
        sudo useradd -s /bin/bash -d /home/$user -g $group -m $user
        echo "创建用户结束"
    fi

    # 设置启动用户的目录权限
    echo "设置启动用户的目录权限"
    sudo chown -R $user:$group $app_dir
    
    # 安装 $app_name 服务
    echo 安装 $app_name 服务
    
    sudo ln -s $app_dir/$app_name.jar /etc/init.d/$app_name
    #chkconfig 2345 80 90
    #description:project-demo
    # sudo chkconfig --add $app_name

    echo "$app_name服务安装结束"

    # 授予相关权限
    sudo chmod -R 755 $app_dir

    # 应用程序安装完成
    echo "应用程序安装完成"

    startApp

}

updateApp(){
    # 检测要更新的应用是否存在,不存在则退出更新
    if [ ! -f "$app_dir/$app_name.jar" ]; then
        echo "没有找到$app_name.jar在目录$app_dir下"
        exit 1
    fi

    if [ ! -f "$app_dir/config/application.yml" ]; then
        if [ ! -f "$app_dir/config/application.properties" ]; then
			echo "没有找到application.yml 和 application.properties 在目录$app_dir/config"
			exit 1
		fi
    fi

    echo "停止服务,'$app_name'"
    sudo su -$suer -c "service $app_name stop"
    sleep 15

    copyApp
    startApp
}

uninstallApp(){
    echo "卸载应用开始"
    echo "停止服务 '$app_name'"
    sudo su - $user -c "service $app_name stop"
    sleep 15

    echo "从 init.d 中删除服务"
    # sudo chkconfig --del $app_name
    sudo rm /etc/init.d/$app_name

    echo "删除应用文件"
    sudo rm -rf $app_dir
    
    echo "卸载应用结束"
}

# ==============================命令执行区=======================================
# 传入参数处理区
# 判断应用名称是否为空
if [ -z "$app_name" ]; then
	echo "应用的名称[app_name]不能为空!"
	exit 1;
fi

# 判断应用端口是否为空
if [ -z "$app_port" ]; then
	echo "应用的端口[app_port]不能为空!"
	exit 1;
fi

# 判断应用打包模块名称是否为空
if [ -z "$package_module_name" ]; then
	package_module_name=$app_name
fi

# 判断打包jar名称是否为空
if [ -z "$package_jar_name" ]; then
	package_jar_name=$package_module_name
fi

echo "应用打包模块的名称为: $package_module_name"

# 判断当前应用是否已经安装
# sudo chkconfig --list | grep -w $app_name >& /dev/null

# 安装状态,0:表示服务已经安装,1:表示服务没有安装
install_status=0
if [ ! -f "/etc/init.d/$app_name" ]; then
   install_status=1
fi

if [ $install_status -ne 0 ] || [ ! -f "$app_dir/$app_name.jar" ]; then
    if [ $exec_commend = "uninstall" ]; then
        echo "没有找到对应的服务,操作取消"
    else
        installApp
    fi
else
    echo "找到 $app_name 服务,该服务已经被安装!"
    if [ $exec_commend = "uninstall" ]; then
        echo "正在准备卸载应用:$app_name"
        uninstallApp
    else
        echo "正在重新更新服务"
        updateApp
    fi
fi






#! /bin/bash
# 运行命令 ./xx.sh project-demo 7980
# 得到当前目录
curr_dir=$(cd `dirname $0`; pwd)

# 应用程序名称
app_name=$1

# 应用程序执行命令
exec_commend=install

# 应用程序的端口号
app_port=$2

# 应用程序的进程pid
app_pid=""
# 应用程序目录名称
app_dir_name=$app_name

#临时传输的拷贝目录名称
temp_transfer_app_dir_name=$app_name-transfer

# 应用程序目录
app_dir=$curr_dir/$app_dir_name

# 临时传输的拷贝目录
temp_transfer_app_dir=$curr_dir/$temp_transfer_app_dir_name

#打包的模块名称
package_module_name=$3

# 用户和用户组
user=jenkins
group=jenkins

# ==============================函数执行区=======================================
# 处理临时传输目录,使其规范化
dealWithTempTransferDir(){
    if [ -d "$temp_transfer_app_dir/$package_module_name" ]; then
       sudo  mv $temp_transfer_app_dir/$package_module_name/target/$app_name.jar $temp_transfer_app_dir
       sudo  rm -rf $temp_transfer_app_dir/$package_module_name
       echo  "-----临时传输目录处理完毕!"
	else
	   echo  "-----$temp_transfer_app_dir/$package_module_name临时目录处理失败,相关路径不存在!"
    fi

}

# 从临时传输文件目录中拷贝应用
copyApp(){
    # 处理临时传输目录,使其规范化
    dealWithTempTransferDir

    # 删除应用程序目录
    sudo rm -rf $app_dir
    #判断引用程序目录是否存在
    if [ ! -d "$app_dir" ]; then
      sudo mkdir $app_dir
      sudo cp -f -r $temp_transfer_app_dir/* $app_dir
      # 授予创建目录的执行权限
      sudo chmod -R 755 $app_dir
      checkUserAndGroupExist
      echo -----目录创建成功,并成功拷贝数据.
    else
      echo -----应用程序目录删除失败:$app_dir
      exit 1
    fi
    # 删除临时传输目录
    # sudo rm -rf $temp_transfer_app_dir

}

# 检测用户及用户组是否创建
checkUserAndGroupExist(){
	# exist状态,0:表示已经存在,1:表示不存在
	# 检测用户组是否存在,不存在则进行创建
	egrep "^$group" /etc/group >& /dev/null
	group_exist=$?

	# 检测用户是否存在,不存在则进行创建
	egrep "^$user" /etc/passwd >& /dev/null
	user_exist=$?
    echo "----------------------------$group_exist-------$user_exist"
	
	if [ $group_exist -eq 0 ] && [ $user_exist -eq 0 ]; then

	   # 设置启动用户的目录权限
	   echo "设置启动用户的目录权限"
	   sudo chown -R $user:$group $app_dir
	fi
}

# 启动应用
startApp(){
    echo "开始服务 '$app_name'"

    # 开始服务
    sudo su - $user -c "sudo service $app_name start"
   
    echo "正在等待服务启动成功"
    app_pid=""
    count=0
    # 若 进程pid为空,则监听pid
    while [ -z "$app_pid" ]
    do
      if [ $count -eq 60 ];then
         echo 应用程序 $app_name 在5分钟内没有监听到进程pid,自动跳出监听程序,避免脚本死循环执行...
         break;
      fi
      count=`expr $count + 1`
      sleep 5
	  # 此处可以改进为通过进程号获取端口号来监听...
      app_pid=$(sudo netstat -anp|grep 'LISTEN'|grep $app_port|awk '{printf $7}'|cut -d/ -f1)
      echo ---------$app_pid --------------$count -------port:$app_port
    done

    #等待15秒,包服务启动成功
    sleep 15
    echo "应用程序$app_name启动成功,进程pid=$app_pid"
}


# 安装应用
installApp(){
    copyApp
    echo "-----正在安装应用app_name=$app_name"

    # 检测要安装的应用是否存在,不存在则退出安装
    if [ ! -f "$app_dir/$app_name.jar" ]; then
        echo "没有找到$app_name.jar在目录$app_dir下"
        exit 1
    fi

    if [ ! -f "$app_dir/config/application.yml" ]; then
        if [ ! -f "$app_dir/config/application.properties" ]; then
			echo "没有找到application.yml 和 application.properties 在目录$app_dir/config"
			exit 1
		fi
    fi

    # 开始安装用户和组
    echo "正在检测安装用户和组是否存在,不存在则进行创建"

    # 检测用户组是否存在,不存在则进行创建
    egrep "^$group" /etc/group >& /dev/null
    if [ $? -ne 0 ]; then
        echo "创建用户组开始"
       sudo groupadd $group
        echo "创建用户组结束"
    fi

    # 检测用户是否存在,不存在则进行创建
    egrep "^$user" /etc/passwd >& /dev/null
    if [ $? -ne 0 ]; then
        echo "创建用户开始"
        sudo useradd -s /bin/bash -d /home/$user -g $group -m $user
        echo "创建用户结束"
    fi

    # 设置启动用户的目录权限
    echo "设置启动用户的目录权限"
    sudo chown -R $user:$group $app_dir
    
    # 安装 $app_name 服务
    echo 安装 $app_name 服务
    
    sudo ln -s $app_dir/$app_name.jar /etc/init.d/$app_name
    #chkconfig 2345 80 90
    #description:project-demo
    # sudo chkconfig --add $app_name

    echo "$app_name服务安装结束"

    # 授予相关权限
    sudo chmod -R 755 $app_dir

    # 应用程序安装完成
    echo "应用程序安装完成"

    startApp

}

updateApp(){
    # 检测要更新的应用是否存在,不存在则退出更新
    if [ ! -f "$app_dir/$app_name.jar" ]; then
        echo "没有找到$app_name.jar在目录$app_dir下"
        exit 1
    fi

    if [ ! -f "$app_dir/config/application.yml" ]; then
        if [ ! -f "$app_dir/config/application.properties" ]; then
			echo "没有找到application.yml 和 application.properties 在目录$app_dir/config"
			exit 1
		fi
    fi

    echo "停止服务,'$app_name'"
    sudo su -$suer -c "service $app_name stop"
    sleep 15

    copyApp
    startApp
}

uninstallApp(){
    echo "卸载应用开始"
    echo "停止服务 '$app_name'"
    sudo su - $user -c "service $app_name stop"
    sleep 15

    echo "从 init.d 中删除服务"
    # sudo chkconfig --del $app_name
    sudo rm /etc/init.d/$app_name

    echo "删除应用文件"
    sudo rm -rf $app_dir
    
    echo "卸载应用结束"
}

# ==============================命令执行区=======================================
# 传入参数处理区
# 判断应用名称是否为空
if [ -z "$app_name" ]; then
	echo "应用的名称[app_name]不能为空!"
	exit 1;
fi

# 判断应用端口是否为空
if [ -z "$app_port" ]; then
	echo "应用的端口[app_port]不能为空!"
	exit 1;
fi

# 判断应用打包模块名称是否为空
if [ -z "$package_module_name" ]; then
	package_module_name=$app_name
fi

echo "应用打包模块的名称为: $package_module_name"

# 判断当前应用是否已经安装
# sudo chkconfig --list | grep -w $app_name >& /dev/null

# 安装状态,0:表示服务已经安装,1:表示服务没有安装
install_status=0
if [ ! -f "/etc/init.d/$app_name" ]; then
   install_status=1
fi

if [ $install_status -ne 0 ] || [ ! -f "$app_dir/$app_name.jar" ]; then
    if [ $exec_commend = "uninstall" ]; then
        echo "没有找到对应的服务,操作取消"
    else
        installApp
    fi
else
    echo "找到 $app_name 服务,该服务已经被安装!"
    if [ $exec_commend = "uninstall" ]; then
        echo "正在准备卸载应用:$app_name"
        uninstallApp
    else
        echo "正在重新更新服务"
        updateApp
    fi
fi






