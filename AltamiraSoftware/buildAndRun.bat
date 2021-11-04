@echo off
call mvn clean package
call docker build -t com.altamira/AltamiraSoftware .
call docker rm -f AltamiraSoftware
call docker run -d -p 9080:9080 -p 9443:9443 --name AltamiraSoftware com.altamira/AltamiraSoftware