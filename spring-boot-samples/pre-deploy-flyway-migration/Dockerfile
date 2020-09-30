FROM openjdk:8-alpine as builder

COPY . .

RUN ./gradlew --no-daemon build -x test

FROM openjdk:8-alpine

RUN mkdir /app

COPY --from=builder build/libs/pre-deploy-flyway-migration-*.jar /app/app.jar
#COPY build/libs/pre-deploy-flyway-migration-*.jar /app/app.jar

WORKDIR /app

CMD ["java", "-jar", "app.jar"]