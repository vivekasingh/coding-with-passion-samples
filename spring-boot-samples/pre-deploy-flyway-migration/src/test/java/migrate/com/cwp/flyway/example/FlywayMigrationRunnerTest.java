package migrate.com.cwp.flyway.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({FlywayMigrationRunner.class, JdbcTemplateAutoConfiguration.class})
class FlywayMigrationRunnerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void assertThatFlywayMigrationsAreExecutedWithFlywayMigrationApplicationClass() {

    List<Map<String, Object>> books = jdbcTemplate.queryForList("SELECT * FROM books");

    Map<String, Object> map = ImmutableMap.of("ID", 1L, "TITLE", "Foo", "AUTHOR", "Bar");

    assertAll(
        () -> assertThat(books).hasSize(1),
        () -> assertThat(books.get(0)).containsAllEntriesOf(map)
    );
  }
}