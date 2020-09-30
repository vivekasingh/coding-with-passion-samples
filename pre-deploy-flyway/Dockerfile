FROM openjdk:8-alpine as builder

COPY . .

RUN ./gradlew --no-daemon bootJar

FROM openjdk:8-alpine

RUN mkdir /app

COPY --from=builder build/libs/pre-deploy-flyway-*.jar /app/app.jar

WORKDIR /app

CMD ["java", "-jar", "app.jar"]