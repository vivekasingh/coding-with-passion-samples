# pre-deploy-flyway

This project demonstrates how we can use spring boot application initializer to run flyway migrations without deploying service itself.

This tool is particularly helpful in large databases where schema executing takes longer time and running it along with deployment poses risk of unavailability of service.

**Note:** This utility uses h2 in memory database for demonstration but can be applied on any external database.
## How to?

**Build:**

Run `bootJar` to create an executable jar,
```
./gradlew bootJar 
```


**Deploy:** 

Use `java -jar` command which will start service on port 8080 with an in memory h2 database
```
 java -jar build/libs/pre-deploy-flyway-0.0.1-SNAPSHOT.jar
```


**Execute Flyway Migration:** 

To execute migrations, use following command,
```
java -cp build/libs/pre-deploy-flyway-0.0.1-SNAPSHOT.jar \
     -Dloader.main=migrate.com.vns.flyway.FlywayMigrationRunner \
     org.springframework.boot.loader.PropertiesLauncher
```