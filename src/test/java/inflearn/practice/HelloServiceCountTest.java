package inflearn.practice;

import inflearn.practice.helloboot.HelloBootTest;
import inflearn.practice.helloboot.HelloRepository;
import inflearn.practice.helloboot.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("Taek");
            Assertions.assertThat(helloRepository.countOf("Taek")).isEqualTo(count);
        });
    }
}
