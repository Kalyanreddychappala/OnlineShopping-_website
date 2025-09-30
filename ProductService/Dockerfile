FROM openjdk:17

WORKDIR /app/product/

COPY target/ProductService*.jar /app/product/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]