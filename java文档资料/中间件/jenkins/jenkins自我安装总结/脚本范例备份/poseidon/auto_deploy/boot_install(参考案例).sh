# DCITS
# @since 2018-02-26
# @author limfa@dcits.com
# @purpose POC Shell Script to manually install and configure Springboot App,
# software into a Linux server for projects:
# @project gba, hdxz-monitor

# #############################################################################
# Revision History
#
# Version	Date		Author			Change History
# ---------	-----------	---------------	-------------------------------
# 1		2017-02-25	lmf_knight	New Script
# 2		2017-03-16	lmf_knight	Support Update and Uninstall
# #############################################################################

# #############################################################################
# Note
# 1. This file is to be run as a Shell Script
# 2. This file when run as a script downloads resources from the internet.
# #############################################################################

# #############################################################################
# Pre-Requisite
# 1. Machine has yum repository to install common software.
# 2. Machine is installed with Redhat Linux Operating System / binary compatible
# 3. Machine has sufficient disc space ( MB) for user files.
# 4. Machine has sufficient RAM for user processes.
# 5. User has sudo permisson.
# #############################################################################

# #############################################################################
# Usage
# The commands below assume you are running in the same directory as the script
#	.
# 1. Provide necessary permission for this file to be run as a script
#		In Linux console, enter:
#		$ chmod +x boot_install.sh
#
# 2. Run the script with sudo user
#		In Linux console, enter:
#		$sudo ./boot_install.sh
# #############################################################################

# #############################################################################
# Verification
# This script was verified against the following machine:
# Machine:	Lenovo  / VirtualBox 5.0.18
# OS:		Redhat Enterprise Server 6.5 / 2.6.32-431.el6.x86_64 GNU/Linux
# #############################################################################

# #############################################################################
# Start of Script
# #############################################################################

#!/bin/bash

# requirement: parameter init, ensure they are correct before executing script
APP_NAME=$1
WEB_ROOT=/usr/its/webapps
BOOT_ROOT=$WEB_ROOT/springboot
APP_ROOT=$BOOT_ROOT/$APP_NAME
SHELL_PATH=$(cd `dirname $0`; pwd)
user=webapp
group=server

# requirement: display install springboot application start message
echo "Spring Boot Installation Script V1.0.1" 
echo "------------------------------------------"
echo "Param APP_NAME:		$APP_NAME"
echo "Param APP_ROOT:		$APP_ROOT"
echo "Param SETUP_USER:	$user"
echo "Param SETUP_GROUP:	$group"
echo "Param SHELL_PATH:	$SHELL_PATH"
echo "------------------------------------------"

startApp(){
	echo "Start Service '$APP_NAME'"

	# requirement: start service
	sudo su - $user -c "service $APP_NAME start"
	echo "Please Wait For Start Springboot Application Finish..."
	sleep 25

	# requirement: display applicatoin status message
	echo "Start Service '$APP_NAME' Finish, Status:"
	sudo su - $user -c "service $APP_NAME status"

	# requirement: get running app id
	APP_PID=`ps -ef | grep -w $APP_NAME | grep -v grep | grep -v "/bin/sh" | awk '{ print $2 }'`
	# requirement: get running app port
	PORT=`netstat -nlp | grep $APP_PID | grep -v "/bin/sh" | awk '{ print $4 }' | sed 's/.*://g'`
	# requirement: display start service message

	# requirement: test service is up (response code should be 200)
	echo "Request $APP_NAME($APP_PID) http://localhost:$PORT to Verfiy Installation, Response Code: "
	curl -s -w "%{http_code}\n" --retry 3 --retry-max-time 8 "http://localhost:$PORT/health" -o /dev/null
}

# Fully install application 
# Be sure boot_install.sh app.jar app.conf are in the same folder
installApp(){
	echo "Spring Boot Application Installation Start"

	# requirement: check app.jar is ready
	if [ ! -f "$SHELL_PATH/$APP_NAME.jar" ]
	then 
		echo "Can not find $APP_NAME.jar in Path:$SHELL_PATH, Install Cancelled"
		exit 1
	fi

	# requirement: check app.conf is ready
	if [ ! -f "$SHELL_PATH/$APP_NAME.conf" ] 
	then 
		echo "Can not find $APP_NAME.conf in Path:$SHELL_PATH, Install Cancelled"
		exit 1
	fi
	# requirement: create webapp account first
	echo "Setup Webapp User Start"

	# requirement: create group server if it is not existed
	egrep "^$group" /etc/group >& /dev/null
	if [ $? -ne 0 ]
	then
		echo "Create Group Start"
		groupadd $group
		echo "Create Group End"
	fi

	# requirement: setup user webapp if it is not existed
	egrep "^$user" /etc/passwd >& /dev/null
	if [ $? -ne 0 ]
	then
		echo "Create user Start"
		useradd -s /bin/bash -d /home/$user -g $group -m $user
		echo "Create User End"
	fi

	# requirement: display setup user end message
	echo "Setup Webapp User End"

	# requirement: display create install  folder start message
	echo "Create Installation Folder Start"

	# requirement: create deploy folder
	sudo mkdir -p $APP_ROOT/logs
	sudo mkdir -p $BOOT_ROOT/run
	sudo mkdir -p $WEB_ROOT/logs

	# requirement: display create install folder end message
	echo "Create Installation Folder End"

	# requirement: copy configuration files start message
	echo "Copy Configuration Files Start"

	# requirement: install application, make sure configure is correct
	sudo mv $SHELL_PATH/$APP_NAME.conf $APP_ROOT

	# requirement: copy configuration files finish message
	echo "Copy Configuration Files Finish"

	# requirement: staging deployment artifact start message
	echo "Staging Deployment Artifacts Start"

	# requirement: copy application deployment artifacts
	sudo mv $SHELL_PATH/$APP_NAME.jar $APP_ROOT

	# requirement: staging deployment artifact finish message
	echo "Staging Deployment Artifacts Finish"

	# requirement: set webapps directory ownership
	sudo chown -R $user:$group $WEB_ROOT

	# requirement: display install service start message
	echo "Install init.d Service Start"

	# requirement: install spring boot application as an init.d service
	sudo ln -s $APP_ROOT/$APP_NAME.jar /etc/init.d/$APP_NAME
	sudo chkconfig --add $APP_NAME

	# requirement: display install service end message
	echo "Install init.d Service End"

	# requirement: securing an init.d service
	echo "Securing an init.d Service"
	sudo chmod 500 $APP_ROOT/$APP_NAME.jar
	sudo chmod 400 $APP_ROOT/$APP_NAME.conf
	sudo chmod 755 $APP_ROOT/logs
	sudo chmod 755 $WEB_ROOT/logs

	# requirement: display install application finish message 
	echo "Spring Boot Application Installation Finish"

	startApp
}

updateApp(){
	# requirement: check app.jar is ready for updating
	if [ ! -f "$SHELL_PATH/$APP_NAME.jar" ]
	then 
		echo "Can not find $APP_NAME.jar in Path:$SHELL_PATH, Install Cancelled"
		exit 1
	fi

	# requirement: update webapp account first
	echo "Update Application Start"

	# requirement: remove original version first
	if [ -f "$APP_ROOT/$APP_NAME.jar" ]
	then
		# requirement: stop service
		echo "Stop Service '$APP_NAME'"
		sudo su - $user -c "service $APP_NAME stop"
		sleep 6 

		# requriement: remove app 
		echo "Remove Current Version"
		sudo rm $APP_ROOT/$APP_NAME.jar

		# reuirement: clean console logs
		echo "Clean Console Output Log"
		sudo rm -rf $APP_ROOT/logs/*.*
	fi

	# requirement: copy new app.jar start 
	echo "Copy new Artifact Start"
	sudo mv $SHELL_PATH/$APP_NAME.jar $APP_ROOT
	echo "Copy new Artifact End"

	# requirement: securiting the app
	sudo chown $user.$group $APP_ROOT/$APP_NAME.jar
	sudo chmod 500 $APP_ROOT/$APP_NAME.jar
	# requirement: display update app end message
   	echo "Update Appplication End"	

	startApp
}

uninstallApp(){
	echo "Unistall Application Start"

	echo "Stop Service '$APP_NAME'"
	sudo su - $user -c "service $APP_NAME stop"
	sleep 6

	echo "Remove from init.d Service "
	sudo chkconfig --del $APP_NAME
	sudo rm /etc/init.d/$APP_NAME

	echo "Remove Application Files"
	sudo rm -rf $APP_ROOT	
	sudo rm -rf $BOOT_ROOT/run/$APP_NAME

	echo "Remove Application Logs"
	sudo rm -rf $WEB_ROOT/logs/$APP_NAME/	

	echo "Unistall Application Start"
}

# requirement: check service install or not
sudo chkconfig --list | grep -w $APP_NAME >& /dev/null
if [ $? -ne 0 ] || [ ! -f "$APP_ROOT/$APP_NAME.jar" ]
then
	# requirement: cannot uninstall if service not found
	if [ $2 = "uninstall" ]
	then
		echo "Request to Uninstall, but Service is not Found, Operation Cancel"
		exit 1
	else 
		# requirement: fully install for 1st time
		installApp
	fi
else
	# requirement: app has been installed already
	echo "Service Install Already"
	if [ $2 = "uninstall" ]
	then
		echo "Request to Uninstall Application"
		# requirement: uninstall app
		uninstallApp
	else
		echo "Request to Update Application"
		# requirement: update app
		updateApp	
	fi
fi

# requirement: display finish message
echo "Script Finish"
