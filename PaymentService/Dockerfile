FROM  openjdk:17

WORKDIR /app/payment/

COPY target/PaymentService*.jar /app/payment/application.jar

ENTRYPOINT [ "sh","-c","java -jar application.jar --spring.profiles.active=docker" ]