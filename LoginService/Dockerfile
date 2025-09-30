FROM openjdk:17

WORKDIR /app/login/

COPY target/LoginService*.jar /app/login/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --Spring.profiles.active=docker" ]