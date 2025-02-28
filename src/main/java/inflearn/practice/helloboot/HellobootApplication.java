package inflearn.practice.helloboot;

import inflearn.practice.config.MySpringBootApplication;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@MySpringBootApplication
public class HellobootApplication {
    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
