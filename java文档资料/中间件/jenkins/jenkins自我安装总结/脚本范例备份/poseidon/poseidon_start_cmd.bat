@echo off
rem 应用程序目录名称
set "app_dir_name=poseidon-api-provider"

rem 应用程序目录
set "app_dir=poseidon-api-provider\"

rem 应用程序启动命令文件
set "start_file=startup.bat"

rem 启动端口
set "port=20980"

rem -------------------------------以上为要修改的变量---------------------

rem 当前批处理命令文件所在的目录
set "curr_dir=%~dp0"
set "pid="
set "full_app_dir=%curr_dir%%app_dir%%start_file%"

rem 通过端口号查找pid
for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem 判断pid变量是否为空值,不为空则杀死进程
if defined pid (
    rem 通过taskkill 命令将查找到的pid进程杀死
	taskkill /pid %pid% -t -f
	echo 端口:%port%对应的进程 %pid% 被杀死...
)

echo 正在启动%app_dir_name%的服务,请稍后...
rem 以最小化的方式启动服务
start /min %full_app_dir%

rem 正在等候 app_dir_name 的服务 启动成功
set "pid="

rem 每添加一个服务,该标识最后的数字需要加1,,千万不能忘记.....
:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem 每添加一个服务,该标识最后的数字需要加1,,千万不能忘记.....
if not defined pid goto begin1
rem 监听到app_dir_name服务的端口后,等待15秒,以保证app_dir_name服务真正启动成功
ping -n 15 127.1>nul
echo %app_dir_name%的服务启动成功pid=%pid%

echo ========================================================================

rem 应用程序目录名称
set "app_dir_name=poseidon-web"

rem 应用程序目录
set "app_dir=poseidon-web\"

rem 应用程序启动命令文件
set "start_file=startup.bat"

rem 启动端口
set "port=8085"

rem -------------------------------以上为要修改的变量---------------------

rem 当前批处理命令文件所在的目录
set "curr_dir=%~dp0"
set "pid="
set "full_app_dir=%curr_dir%%app_dir%%start_file%"

rem 通过端口号查找pid
for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem 判断pid变量是否为空值,不为空则杀死进程
if defined pid (
    rem 通过taskkill 命令将查找到的pid进程杀死
	taskkill /pid %pid% -t -f
	echo 端口:%port%对应的进程 %pid% 被杀死...
)

echo 正在启动%app_dir_name%的服务,请稍后...
rem 以最小化的方式启动服务
start /min %full_app_dir%

rem 正在等候 app_dir_name 的服务 启动成功
set "pid="

rem 每添加一个服务,该标识最后的数字需要加1,千万不能忘记.....
:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem 每添加一个服务,该标识最后的数字需要加1,,千万不能忘记.....
if not defined pid goto begin2

rem 监听到app_dir_name服务的端口后,等待15秒,以保证app_dir_name服务真正启动成功
ping -n 15 127.1>nul
echo %app_dir_name%的服务启动成功pid=%pid%

rem 该命令在批处理文件的最后
pause





















