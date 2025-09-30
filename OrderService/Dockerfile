FROM openjdk:17

WORKDIR /app/order/

COPY target/OrderService*.jar /app/order/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]