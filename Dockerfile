FROM openjdk:11-jdk-slim

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} alnut_email_service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","walnut_email_service.jar"]