FROM eclipse-temurin:17

LABEL mentainer="heng@68807@gmail.com"

WORKDIR /app

COPY target/dockercompose-0.0.1-SNAPSHOT.jar /app/dockercompose.jar

ENTRYPOINT ["java","-jar","dockercompose.jar"]