FROM eclipse-temurin:17.0.6_10-jre

LABEL authors="Maciej"

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086

EXPOSE 8080

COPY target/pizza-${VERSION}.jar /opt/pizza/pizza.jar

CMD ["java", "-jar", "/opt/pizza/pizza.jar"]
