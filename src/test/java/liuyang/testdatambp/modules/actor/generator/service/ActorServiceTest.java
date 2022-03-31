package liuyang.testdatambp.modules.actor.generator.service;

import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class ActorServiceTest {
    @Autowired
    ActorService actorService;

    @Test
    void test() {
        actorService.list().stream().forEach(System.out::println);
    }

    @Test
    void testCache() throws InterruptedException {
        actorService.list().stream().forEach(System.out::println);
        TimeUnit.SECONDS.sleep(2);
        actorService.list().stream().forEach(System.out::println);// 202203291051 实测还是发出了两条SQL。
    }

    @Test
    void testCache2() throws InterruptedException {
        // 202203291055 貌似这个还是发出了两条SQL，不知道为啥。
        Actor actor = actorService.getById(145);
        log.info("actor = {}", actor);
        TimeUnit.SECONDS.sleep(2);
        actorService.getById(145);
        log.info("actor = {}", actor);
    }

    @Test
    void testPaginagion() {
    }
}
