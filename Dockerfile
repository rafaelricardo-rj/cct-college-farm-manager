FROM openjdk:8
COPY ./build/libs/ca2019206-V.0.0.1.jar /app/ca2019206-V.0.0.1.jar
CMD ["java", "-jar", "/app/ca2019206-V.0.0.1.jar"]