FROM openjdk:17.0-jdk

WORKDIR /app

COPY /build/libs/randstring-backend-0.0.1-SNAPSHOT.jar /app/backend.jar

CMD ["java", "-jar", "backend.jar"]