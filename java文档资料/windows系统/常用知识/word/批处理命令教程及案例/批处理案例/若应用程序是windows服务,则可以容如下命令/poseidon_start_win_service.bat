rem net start/stop 服务名 ;这种方式启动的windows的服务
@echo off
net stop poseidon-api-provider 
net start poseidon-api-provider 
echo 正在启动 poseidon-api-provider 的dubbo服务,请稍后...

set "notwait=poseidon-api-provider"

:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :20980') do (
  if not %%i == 0 (
	set "notwait=%%i"
  ) 
)
if %notwait% == poseidon-api-provider goto begin1
ping -n 15 127.1>nul

echo poseidon-api-provider的的dubbo服务启动成功pid=%notwait%
rem netstat -aon|findstr 20980 goto begin

net stop poseidon-web
net start poseidon-web
echo 正在启动 poseidon-web 的web服务,请稍后...
set "notwait=poseidon-web"

:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :8085') do (
  if not %%i == 0 (
	set "notwait=%%i"
  ) 
)

if %notwait% == poseidon-web goto begin2
ping -n 20 127.1>nul
echo poseidon-web的的web服务启动成功pid=%notwait%
pause