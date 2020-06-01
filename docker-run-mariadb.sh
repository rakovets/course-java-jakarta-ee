#!/bin/bash
docker stop mariadb
docker rm mariadb
docker run --name mariadb \
  -v /opt/data/mariadb:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -p 3306:3306 \
  -d mariadb:latest

docker ps
