@echo off   
echo ================================================   
echo  Windows环境下mysql数据库的自动备份脚本  
echo  1. 使用当前日期命名备份文件。  
echo  2. 自动删除7天前的备份。  
echo ================================================  
::以“YYYYMMDD”格式取出当前时间。  
set BACKUPDATE=%date:~0,4%%date:~5,2%%date:~8,2%
::设置用户名、密码和要备份的数据库。  

set HOST=10.2.4.11
set USER=root
set PASSWORD=root
set DATABASE=platform
::创建备份目录。  
if not exist "D:\mysql_backup\data"       mkdir D:\mysql_backup\data  

set DATADIR=D:\mysql_backup\data

mysqldump -h%HOST% -u%USER% -p%PASSWORD% --skip-lock-tables --default-character-set=utf8 %DATABASE% > %DATADIR%\mysql_%BACKUPDATE%.sql

::删除7天前的备份。  
forfiles /p "%DATADIR%" /s /m *.* /d -7 /c "cmd /c del @path"

exit


