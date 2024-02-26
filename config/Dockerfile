FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_PROFILES_ACTIVE=native

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:/var/config/configuration

VOLUME /var/config/configuration

EXPOSE 8080

COPY target/config-${VERSION}.jar /opt/config/config.jar

CMD ["java", "-jar", "/opt/config/config.jar"]
