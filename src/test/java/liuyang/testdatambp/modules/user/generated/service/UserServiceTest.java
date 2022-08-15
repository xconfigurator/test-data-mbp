package liuyang.testdatambp.modules.user.generated.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import liuyang.testdatambp.commons.utils.Id;
import liuyang.testdatambp.modules.user.generated.entity.User;
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

    // 以下testInsert/testUpdate01/testUpdate02说明，代码设置优先，如果代码处没有设置该属性值，则MyBatis-Plus自动填充策略生效。
    @Test
    void testInsert() {
        User user = new User();
        user.setId(Id.nextId());
        user.setAge(88);
        //user.setName("bar from test case");
        userService.save(user);
    }

    @Test
    void testUpdate01() {
        User byId = userService.getById(1559142851985608706l);
        byId.setAge(99);
        userService.updateById(byId);
    }

    @Test
    void testUpdate02() {
        User byId = userService.getById(1559143126741884929l);
        byId.setName(null);
        byId.setAge(99);
        userService.updateById(byId);
    }
}
