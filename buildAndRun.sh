#!/bin/sh
mvn clean package && docker build -t com.mycompany/UniAdminSystem .
docker rm -f UniAdminSystem || true && docker run -d -p 9080:9080 -p 9443:9443 --name UniAdminSystem com.mycompany/UniAdminSystem