package migrate.com.vns.flyway;

import static org.springframework.boot.WebApplicationType.NONE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

/**
 * Utility to run flyway migration without starting service.
 *
 * <p>`FlywayMigrationRunner` uses similar infrastructure as service initializer does but with very
 * few auto configurations enabled i.e. DataSourceAutoConfiguration and FlywayAutoConfiguration.
 */
@SpringBootConfiguration
@Import({DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class})
public class FlywayMigrationRunner {

  public static void main(String[] args) {

    SpringApplication application =
        new SpringApplicationBuilder(FlywayMigrationRunner.class)
            .web(NONE).build();

    application.run(args);
  }
}