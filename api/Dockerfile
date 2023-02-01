FROM maven:3-openjdk-18 AS builder
WORKDIR /usr/src/build
COPY . .
RUN mvn clean package


FROM openjdk:18-jdk-alpine
WORKDIR /usr/src/app
COPY --from=builder /usr/src/build/target/api-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","api-0.0.1-SNAPSHOT.jar"]
