# Moneyfi Backend
### A Code and Design Workshop Project

This is the Backend for Moneyfi Project at the Code Workshop.
### To run this on Docker
First you need to start the Mysql Databse for the Data.
`docker run --name mysql-standalone -d -p 3306:3306 -e MYSQL_DATABASE=moneyfi -e MYSQL_ROOT_PASSWORD='23code42' -e MYSQL_ROOT_HOST=% mysql/mysql-server:latest`
Then run the Backend after the Mysql Server is up.
`docker run -d -p 8080:8080 --name backend --link mysql-standalone:mysql-standalone vale5566/moneyfi_backend:latest`


### To run the whole Project on Docker
`sh -c "$(curl -fsSL https://raw.github.com/vale5566/moneyfi-backend/master/docker/docker.sh)"`
