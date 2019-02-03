@echo off
rem sw异地备份
::以下是远程备份，根据实际情况修改账号和密码，ip地址，远程文件夹名字。
::如果要多台远程备份，复制以下代码一份到最后面修改对应信息即可。
rem 远程服务器的用户名
set remoteUsername=administrator
rem 远程服务器的密码
set remotePassword=bjhyrjb_001
rem 远程服务器的路径
set remoteServer=\\192.168.0.2
rem 远程服务器共享文件名
set remotePath=\swdbbak
rem 本地文件夹路径
set localPath=E:\sworacleapk\sworacleapk-win64\数据库备份\swdbbak

@echo
@echo "数据库远程备份中......"
net use %remoteServer%\ipc$ "%remotePassword%" /user:%remoteUsername%
copy "%localPath%" %remoteServer%%remotePath%
@echo "数据库远程备份完成!"
