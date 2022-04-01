package liuyang.testdatambp.modules.user.generated.mapper;

import liuyang.testdatambp.modules.user.generated.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liuyang(wx)
 * @since 2022/4/1
 */
@SpringBootTest
@Slf4j
public class UserMapperPureMyBatisAPITest {

    @Autowired
    private UserMapper userMapper;// 这个警告可以忽略

    private static final Long ID = 666L;

    // 使用MyBatis API begin 202204011051
    @Test
    void testSelect() {
        User user = userMapper.selectUserById(ID);
        log.info("User = {}", user);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setId(ID);
        user.setAge(38);
        user.setName("liuyang");
        user.setEmail("xconfigurator@hotmail.com");
        userMapper.insertUser(user);
    }

    @Test
    void testUpdate() {
        User user = userMapper.selectUserById(ID);
        user.setAge(18);
        userMapper.updateUser(user);
    }

    @Test
    void testDelete() {
        userMapper.deleteUserById(ID);
    }
    // 使用MyBatis API end 202204011051
}
