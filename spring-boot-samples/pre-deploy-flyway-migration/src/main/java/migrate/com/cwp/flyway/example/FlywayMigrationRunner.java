package migrate.com.cwp.flyway.example;

import static org.springframework.boot.WebApplicationType.NONE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

/**
 * Utility to run flyway migration without starting service.
 * <p>
 * Application started with `FlywayMigrationRunner` will be using same spring boot infrastructure
 * for loading configurations but will be initializing only selected auto configurations which are
 * DataSourceAutoConfiguration and FlywayAutoConfiguration.
 */
@SpringBootConfiguration
@Import({DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class})
public class FlywayMigrationRunner {

  public static void main(String[] args) {

    SpringApplication application = new SpringApplicationBuilder(FlywayMigrationRunner.class).web(NONE).build();

    application.run(args);
  }
}