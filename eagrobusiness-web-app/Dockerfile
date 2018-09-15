FROM openjdk:8-jdk-alpine

LABEL maintainer="es_goncalves@msn.com"

ENV WEBAPP_PORT=80

VOLUME /tmp

ARG JAR_FILE=target/eagrobusiness-web-app-1.0-SNAPSHOT.jar

ADD ${JAR_FILE} webapp.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/webapp.jar"]
EXPOSE ${WEBAPP_PORT}