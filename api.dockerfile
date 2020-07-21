# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN sleep 3m
RUN mvn -f /home/app/pom.xml clean package
RUN ls /home/app/target

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/shortenlink-0.0.1-SNAPSHOT.jar /usr/local/lib/ShortenlinkApplication.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/ShortenlinkApplication.jar"]