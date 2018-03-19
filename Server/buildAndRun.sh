#!/bin/sh
mvn clean package && docker build -t xyz.meistertobias/jndi-server .
docker rm -f jndi-server || true && docker run -d -p 8080:8080 -p 4848:4848 --name jndi-server xyz.meistertobias/jndi-server 
