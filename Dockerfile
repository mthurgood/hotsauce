FROM openjdk:19-jdk-alpine

COPY target/hotsauce-0.0.1-SNAPSHOT.jar hotsauce-0.0.1.jar

ENTRYPOINT ["java","-jar","/hotsauce-0.0.1.jar"]