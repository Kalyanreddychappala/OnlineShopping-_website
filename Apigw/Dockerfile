FROM openjdk:17

WORKDIR /app/apigw/

COPY  target/Apigw*.jar /app/apigw/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]