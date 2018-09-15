FROM openjdk:8-jdk-alpine

LABEL maintainer="es_goncalves@msn.com"

VOLUME /tmp

ARG JAR_FILE=target/zuul-proxy-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} zuul-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/zuul-server.jar"]
EXPOSE 8000