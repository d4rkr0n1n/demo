FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

ENTRYPOINT ["./mvnw", "spring-boot:run"]

FROM base as local
CMD ["-Dspring-boot.run.profiles=local"]

FROM base as development
CMD ["-Dspring-boot.run.profiles=development"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/demo-*.jar /demo.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/demo.jar"]