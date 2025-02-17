package inflearn.practice.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("Taek")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("Taek")).isEqualTo(0);

        helloRepository.increaseCount("Taek");
        Assertions.assertThat(helloRepository.countOf("Taek")).isEqualTo(1);

        helloRepository.increaseCount("Taek");
        Assertions.assertThat(helloRepository.countOf("Taek")).isEqualTo(2);
    }
}
