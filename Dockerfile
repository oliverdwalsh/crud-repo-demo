FROM adoptopenjdk/openjdk11:alpine-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ARG CONFIG_SERVER_URL

ENV CONFIG_SERVER_URL =$CONFIG_SERVER_URL

ENTRYPOINT ["java", "-jar", "/app.jar"]
