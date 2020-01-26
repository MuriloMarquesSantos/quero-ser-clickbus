FROM openjdk:8-jdk-alpine

RUN mkdir /places-manager

WORKDIR /places-manager

COPY target/places-manager-0.0.1-SNAPSHOT.jar /places-manager/places-manager-0.0.1-SNAPSHOT.jar

CMD ["sh", "-c", "java -jar places-manager-0.0.1-SNAPSHOT.jar"]
