FROM openjdk:17

WORKDIR /app/register/

COPY target/Resgistration*.jar /app/register/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]