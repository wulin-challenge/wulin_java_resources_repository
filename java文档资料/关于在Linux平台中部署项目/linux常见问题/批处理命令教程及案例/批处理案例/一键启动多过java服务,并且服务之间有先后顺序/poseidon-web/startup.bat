@echo off
title poseidon-web.jar·þÎñ
set "curr_dir=%~dp0"
set "app_dir=poseidon-web.jar"
set "full_app_dir=%curr_dir%%app_dir%"
%~d0
cd %curr_dir%

java -Xms256M -Xmx512M  -jar %app_dir%
exit

