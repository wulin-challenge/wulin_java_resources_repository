#!  /bin/bash
# 得到当前目录
curr_dir=$(cd `dirname $0`; pwd)
#切换到当前工作目录
cd $curr_dir
nohup java -Xms256M -Xmx800M -jar ./poseidon-web.jar  &  
