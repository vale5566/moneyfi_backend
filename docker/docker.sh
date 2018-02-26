#!/bin/bash
docker run --name mysql-standalone -d -p 3306:3306 -e MYSQL_DATABASE=moneyfi -e MYSQL_ROOT_PASSWORD='23code42' -e MYSQL_ROOT_HOST=% mysql/mysql-server:latest
sleep 20s
docker run -d -p 8080:8080 --name backend --link mysql-standalone:mysql-standalone vale5566/moneyfi_backend:latest
docker run --name website -d -p 80:80 --link backend:moneyfi-backend vale5566/moneyfi_website:latest
