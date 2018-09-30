FROM openjdk:8-jdk-alpine

LABEL maintainer="es_goncalves@msn.com"

VOLUME /api-eureka-client-persistent-storage

ARG JAR_FILE=target/eureka-client-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-client.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker","-jar", "/eureka-client.jar"]
EXPOSE 8700