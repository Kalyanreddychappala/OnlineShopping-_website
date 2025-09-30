FROM openjdk:17

WORKDIR /app/discovery/

COPY target/DiscoveryService*.jar /app/discovery/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]