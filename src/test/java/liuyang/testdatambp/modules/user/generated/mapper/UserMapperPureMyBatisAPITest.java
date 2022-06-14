package liuyang.testdatambp.modules.user.generated.mapper;

import liuyang.testdatambp.modules.user.generated.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 202206140915 实测这一级缓存貌似在MyBatis-Plus环境中是被默认关闭的。
 *
 * @author liuyang(wx)
 * @since 2022/4/1
 */
@SpringBootTest
@Slf4j
public class UserMapperPureMyBatisAPITest {

    @Autowired
    private UserMapper userMapper;// 这个警告可以忽略

    @Autowired
    private SqlSessionFactory sqlSessionFactory;// 20220614 为啥这个貌似不顶用？ 答：因为使用了多数据源。这个工厂默认连接的是其他的库。

    private static final Long ID = 666L;

    // 使用MyBatis API begin 202204011051
    //@Test
    @RepeatedTest(4)// 这样仍然会发四次sql，可见每次测试使用的是不同的SqlSession
    void testSelect() {
        User user = userMapper.selectUserById(ID);
        log.info("User = {}", user);
    }

    @Test
    void testSelectCache() {
        for (int i = 0; i < 4; ++i) {
            User user = userMapper.selectUserById(ID);// 202206140912实测，为啥也不过一级缓存呢？
            log.info("User = {}", user);
        }
    }

    // 20220614 问：这个操作不正常 答：使用了动态数据源
    @Test
    void testSelectViaSqlSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        for (int i = 0; i < 4; ++i) {
            User user = mapper.selectUserById(ID);// 20220614实测 这个查不到
            log.info("User = {}", user);
        }

        List<User> users = mapper.selectList(null);// 20220614实测 这个可以查到
        users.stream().forEach(System.out::println);

        sqlSession.close();
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
