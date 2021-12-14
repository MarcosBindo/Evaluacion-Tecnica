FROM openjdk:8-jdk-alpine
MAINTAINER marcosbindo13@gmail.com

COPY target/nubi-0.0.1-SNAPSHOT.war nubi-server-1.0.0.war

ENTRYPOINT ["java","-jar","nubi-server-1.0.0.war"]