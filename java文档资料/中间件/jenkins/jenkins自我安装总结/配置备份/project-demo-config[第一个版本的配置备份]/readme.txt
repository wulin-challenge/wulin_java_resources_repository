1. jenkins执行的脚步

exe_dir=/home/wulin/jenkins/jenkins_projects_me/project-demo-run/conf
chmod +x $exe_dir/auto_deploy.sh
sed -i 's/\r$//' $exe_dir/auto_deploy.sh
$exe_dir/auto_deploy.sh

===================================================================================================================================