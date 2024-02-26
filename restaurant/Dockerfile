FROM eclipse-temurin:17.0.6_10-jre

LABEL authors="Maciej"

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086

EXPOSE 8080

COPY target/restaurant-${VERSION}.jar /opt/restaurant/restaurant.jar

CMD ["java", "-jar", "/opt/restaurant/restaurant.jar"]
