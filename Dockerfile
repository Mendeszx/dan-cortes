FROM openjdk:17-alpine

ARG VAR1="jdbc:postgresql://host.docker.internal:5432/hair_pass"
ARG VAR2="postgres"
ARG VAR3="admin"

ENV DB_URL=$VAR1
ENV DB_USER=$VAR2
ENV DB_PASSWORD=$VAR3

WORKDIR /app

COPY target/hair-pass-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

LABEL maintainer="hair-pass-app"

CMD ["java", "-jar", "app.jar"]
