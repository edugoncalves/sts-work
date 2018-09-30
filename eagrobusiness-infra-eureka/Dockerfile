FROM openjdk:8-jdk-alpine

LABEL maintainer="es_goncalves@msn.com"

VOLUME /api-eureka-server-persistent-storage

ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "/eureka-server.jar"]
EXPOSE 8761