#!  /bin/bash
# 得到当前目录
curr_dir=$(cd `dirname $0`; pwd)
#切换到当前工作目录
cd $curr_dir
nohup java -server -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/webapp/oom_dump/ -jar ./poseidon-web.jar &  
