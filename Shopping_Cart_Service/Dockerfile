FROM openjdk:17

WORKDIR /app/cart/

COPY target/Shopping_Cart_Service*.jar /app/cart/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]