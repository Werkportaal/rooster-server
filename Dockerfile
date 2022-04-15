FROM maven:3.8.4-openjdk-17 AS build

COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:17
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} /usr/local/lib/server.jar
ENTRYPOINT [ "java","-jar","/usr/local/lib/server.jar" ]
