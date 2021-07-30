FROM openjdk:12-alpine
COPY target/MediScreen-0.0.1-SNAPSHOT.jar patient.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "patient.jar"]