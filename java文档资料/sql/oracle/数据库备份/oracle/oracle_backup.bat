@echo off   
echo ================================================   
echo  Windows环境下Oracle数据库的自动备份脚本  
echo  1. 使用当前日期命名备份文件。  
echo  2. 自动删除7天前的备份。  
echo ================================================  
::以“YYYYMMDD”格式取出当前时间。  
set BACKUPDATE=%date:~0,4%%date:~5,2%%date:~8,2%
::设置用户名、密码和要备份的数据库。
  
set host=10.2.4.11
set USER=yzpt
set PASSWORD=yz_5141bzjy_2
set DATABASE=orcl
::创建备份目录。  
if not exist "D:\oracle_backup\data"       mkdir D:\oracle_backup\data  
if not exist "D:\oracle_backup\log"        mkdir D:\oracle_backup\log  

set DATADIR=D:\oracle_backup\data
set LOGDIR=D:\oracle_backup\log

exp %USER%/%PASSWORD%@%DATABASE% file=%DATADIR%\data_%BACKUPDATE%.dmp log=%LOGDIR%\log_%BACKUPDATE%.log

::删除7天前的备份。  
forfiles /p "%DATADIR%" /s /m *.* /d -7 /c "cmd /c del @path"
forfiles /p "%LOGDIR%" /s /m *.* /d -7 /c "cmd /c del @path"

exit

