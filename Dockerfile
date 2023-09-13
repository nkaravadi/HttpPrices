#In current folder:
#colima ssh
#docker build -t nagakaravadi/httpprices-cop:v2 .
#docker push nagakaravadi/httpprices-cop:v2
#

#Java 17 Maven Image Builder
FROM maven:3.8.1-openjdk-17-slim as builder

# Local code to container image
WORKDIR /app
COPY pom.xml .
COPY src ./src

#Build
RUN mvn clean package -DskipTests

#JDK Image for Runtime
FROM openjdk:17-jdk-slim-buster

# Copy Jar from builder stage
COPY --from=builder /app/target/price-service*.jar /application.jar

CMD ["java", "-jar", "/application.jar"]
