#!/usr/bin/env bash

set -e

docker login;

docker build eagrobusiness-infra-eureka-client -t esgoncalcves/api-eureka-client;
docker build eagrobusiness-infra-zuul -t esgoncalcves/api-zuul-gateway;
docker build eagrobusiness-infra-eureka -t esgoncalcves/api-eureka-serves;
docker build eagrobusiness-api-produto -t esgoncalcves/api-produto;
docker build eagrobusiness-web-app  -t esgoncalcves/webapp-eagrobusiness;
docker push esgoncalcves/api-eureka-client;
docker push esgoncalcves/api-zuul-gateway;
docker push esgoncalcves/api-produto;
docker push esgoncalcves/api-eureka-serves;
docker push esgoncalcves/webapp-eagrobusiness;
