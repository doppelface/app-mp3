FROM openjdk:17.0.2-jdk
WORKDIR /app/mp3-app
COPY backend/build/libs/songService-1.0-SNAPSHOT.jar /app/songService/songService.jar
ENTRYPOINT ["java", "-jar", "songService.jar"]