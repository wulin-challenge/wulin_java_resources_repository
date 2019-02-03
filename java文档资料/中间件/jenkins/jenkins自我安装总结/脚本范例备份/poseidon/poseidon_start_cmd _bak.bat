@echo off
set "port=20980"
set "pid="
set "curr_dir=%~dp0"
set "app_dir=poseidon-api-provider\startup.bat"
set "full_app_dir=%curr_dir%%app_dir%"

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

echo 正在启动poseidon-api-provider的dubbo服务,请稍后...
rem 以最小化的方式启动服务
start /min %full_app_dir%

rem 正在等候 poseidon-api-provider的dubbo服务 启动成功
set "pid="
:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)
if not defined pid goto begin1
rem 监听到dubbo服务的端口后,等待15秒,以保证dubbo服务真正启动成功
ping -n 15 127.1>nul
echo poseidon-api-provider的的dubbo服务启动成功pid=%pid%

echo ========================================================================

set "port=8085"
set "pid="
set "app_dir=poseidon-web\startup.bat"
set "full_app_dir=%curr_dir%%app_dir%"

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
echo 正在启动 poseidon-web 的web服务,请稍后...
rem 以最小化的方式启动服务
start /min %full_app_dir%

rem 正在等候 poseidon-api-provider的dubbo服务 启动成功
set "pid="
:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)
if not defined pid goto begin2
rem 监听到web服务的端口后,等待20秒,以保证web服务真正启动成功
ping -n 20 127.1>nul
echo poseidon-web的的web服务启动成功pid=%pid%
pause





















