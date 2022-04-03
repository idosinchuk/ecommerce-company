FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ADD build/libs/ecommerce-company-0.0.1-SNAPSHOT.jar ecommerce-company-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "ecommerce-company-0.0.1-SNAPSHOT.jar"]