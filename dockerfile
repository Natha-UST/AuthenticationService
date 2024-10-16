FROM openjdk:17-oracle
COPY ./target/Authentication-Service-0.0.1-SNAPSHOT.jar Authentication-Service.jar
CMD ["java", "-jar", "Authentication-Service.jar"]
