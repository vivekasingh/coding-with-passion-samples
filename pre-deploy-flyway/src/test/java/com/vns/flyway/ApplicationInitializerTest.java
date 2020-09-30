package com.vns.flyway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest(classes = ApplicationInitializer.class)
class ApplicationInitializerTest {
	@Autowired private JdbcTemplate jdbcTemplate;

	@Test
	void assertThatFlywayMigrationsAreExecutedWhenServiceStarts() {

		List<Map<String, Object>> books = jdbcTemplate.queryForList("SELECT * FROM books");

		Map<String, Object> map = ImmutableMap.of("ID", 1L, "TITLE", "Foo", "AUTHOR", "Bar");

		assertAll(
				() -> assertThat(books).hasSize(1),
				() -> assertThat(books.get(0)).containsAllEntriesOf(map)
		);
	}
}