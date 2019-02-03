#!  /bin/bash
current=`date +%s`
root_path=/home/wulin/jenkins/jenkins_projects_me
copy_jar_path=$root_path/project-demo-run/project-demo-build/target
rm -f $root_path/project-demo-run/project-demo-build*.jar
mv $copy_jar_path/project-demo-build*.jar $root_path/project-demo-run
rm -rf $root_path/project-demo-run/project-demo-build
rm -f $root_path/project-demo-run/project-demo-build*-sources.jar
mv $root_path/project-demo-run/project-demo-build*.jar $root_path/project-demo-run/project-demo-build.jar
chmod +x $root_path/project-demo-run/project-demo-build.jar
chmod -R +x $root_path/project-demo-run
#拷贝配置文件和v.license文件
rm -rf $root_path/project-demo-run/config/
mv $root_path/project-demo-run/conf/* $root_path/project-demo-run
#启动程序
current_dir=$root_path/project-demo-run
cd $current_dir
rm -f $current_dir/nohup.out
pid=$(ps -ef | grep -v 'grep' | grep 'project-demo-build' | awk '{print $2}')
[ -n "$pid" ] && kill -9 $pid
echo $current_dir
#导入java环境
export JAVA_HOME=/usr/java/jdk1.8.0_171
export JRE_HOME=${JAVA_HOME}/jre
export JAVA_PATH=${JAVA_HOME}/bin:${JRE_HOME}/bin
export PATH=$PATH:${JAVA_PATH}
nohup java -Xms256M -Xmx512M -jar $current_dir/project-demo-build.jar &
sleep 3
tail -f $current_dir/nohup.out





















