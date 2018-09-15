FROM openjdk:8-jdk-alpine

LABEL maintainer="es_goncalves@msn.com"

VOLUME /tmp

ENV HOST_EUREKA=discovery_server

ARG JAR_FILE=target/eureka-client-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-client.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/eureka-client.jar"]
EXPOSE 8001