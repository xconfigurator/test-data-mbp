package liuyang.testdatambp.modules.user.generated.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liuyang
 * @scine 2021/6/8
 */
@Slf4j
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void test01() {
        userService.list().stream().forEach(System.out::println);
    }
}
