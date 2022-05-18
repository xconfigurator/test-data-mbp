package liuyang.testdatambp.modules.actoridsnowflake.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import liuyang.testdatambp.modules.actoridsnowflake.entity.ActorIdSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 参考文档：
 * https://www.mybatis-plus.com/guide/crud-interface.html#service-crud-%E6%8E%A5%E5%8F%A3
 * @author liuyang(wx)
 * @since 2022/5/18
 */
@SpringBootTest
@Slf4j
public class ActorIdSnowflakeServiceTest {

    @Autowired
    private ActorIdSnowflakeService service;

    @Test
    void testCount() {
        long count = service.count();
        log.info("count = {}", count);
    }

    // 批量添加
    @Test
    void testSaveBatch() {
        List<ActorIdSnowflake> list = new ArrayList<>();
        for (int id = 1100; id <= 1110; id++) {
            ActorIdSnowflake entity = new ActorIdSnowflake();
            entity.setActorId(Long.valueOf(id));
            entity.setFirstName("yang batch");
            entity.setLastName("liu");
            entity.setLastUpdate(new Date());
            list.add(entity);
        }
        boolean b = service.saveBatch(list);
        log.info("b = {}", b);
    }

    @Test
    void testRemove() {
        LambdaUpdateWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaUpdateWrapper = Wrappers.<ActorIdSnowflake>lambdaUpdate();
        actorIdSnowflakeLambdaUpdateWrapper.eq(ActorIdSnowflake::getFirstName, "yang batch");

        boolean remove = service.remove(actorIdSnowflakeLambdaUpdateWrapper);
        log.info("remove = {}", remove);
    }
}
