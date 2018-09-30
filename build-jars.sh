#!/usr/bin/env bash

set -e

cd eagrobusiness-infra-eureka; 
mvn clean package -DskipTests=true; 
cd -
cd eagrobusiness-web-app; 
mvn clean package -DskipTests=true; 
cd -
cd eagrobusiness-infra-eureka-client; 
mvn clean package -DskipTests=true; 
cd -
find . -name *SNAPSHOT.jar -exec du -h {} \;