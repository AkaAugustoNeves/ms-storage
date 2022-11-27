FROM openjdk:11-jre-slim

WORKDIR /app

ENV EUREKA_URL ""
ENV DB_STORAGE_URL ""
ENV DB_STORAGE_USERNAME ""
ENV DB_STORAGE_PASSWORD ""
ENV BASE_PATH_COMPROVE_PERSON_STORAGE "/app/volume"

COPY target/ms-storage-0.0.1-SNAPSHOT.jar /app/ms-storage.jar

EXPOSE 8081

CMD ["java", "-jar", "ms-storage.jar"]