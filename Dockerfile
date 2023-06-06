FROM openjdk:17 as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base as build
RUN ./mvnw package

FROM base as local
CMD ["./mvnw", "spring-boot:run","-Dspring-boot.run.profiles=local"]

FROM base as development
CMD ["./mvnw", "spring-boot:run","-Dspring-boot.run.profiles=development"]

FROM base as test
CMD ["./mvnw", "test"]

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/demo-*.jar /demo.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/demo.jar"]