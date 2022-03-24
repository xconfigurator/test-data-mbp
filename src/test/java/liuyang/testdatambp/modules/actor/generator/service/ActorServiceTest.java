package liuyang.testdatambp.modules.actor.generator.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ActorServiceTest {
    @Autowired
    ActorService actorService;

    @Test
    void test() {
        actorService.list().stream().forEach(System.out::println);
    }
}
