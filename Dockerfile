FROM maven:3.9-eclipse-temurin-24-alpine AS build
WORKDIR /build

COPY pom.xml ./
COPY service/pom.xml service/
COPY serviceprovider/pom.xml serviceprovider/
COPY serviceconsumer/pom.xml serviceconsumer/

COPY service service
COPY serviceprovider serviceprovider
COPY serviceconsumer serviceconsumer

RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:24-jre-alpine
WORKDIR /app

RUN mkdir lib
COPY --from=build /build/*/target/*.jar lib/

ENTRYPOINT ["java", "--module-path", "lib", "--module", "org.example.modules.serviceconsumer/org.example.modules.serviceconsumer.consumer.Main"]
