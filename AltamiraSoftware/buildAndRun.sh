#!/bin/sh
mvn clean package && docker build -t com.altamira/AltamiraSoftware .
docker rm -f AltamiraSoftware || true && docker run -d -p 9080:9080 -p 9443:9443 --name AltamiraSoftware com.altamira/AltamiraSoftware