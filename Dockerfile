#FROM ubuntu:latest AS build   == mais simples porém com duplicação e cache do docker recria automaticamente sempre
#
#RUN apt-get update
#RUN apt-get install openjdk-21-jdk -y
#COPY . .
#
#RUN apt-get install maven -y
#RUN mvn clean install
#
#FROM openjdk:21-jdk-slim
#
#EXPOSE 8080
#
#COPY --from=build /target/especiesAPI-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
#-------------------------------------------------------------------------------

# Stage de build
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn -B package -DskipTests

# Stage de runtime
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]















