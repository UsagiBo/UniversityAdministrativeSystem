@echo off
call mvn clean package
call docker build -t com.mycompany/UniAdminSystem .
call docker rm -f UniAdminSystem
call docker run -d -p 9080:9080 -p 9443:9443 --name UniAdminSystem com.mycompany/UniAdminSystem