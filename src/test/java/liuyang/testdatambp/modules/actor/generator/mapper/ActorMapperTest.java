package liuyang.testdatambp.modules.actor.generator.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liuyang(wx)
 * @since 2022/3/25
 */
@SpringBootTest
@Slf4j
public class ActorMapperTest {

    @Autowired
    private ActorMapper actorMapper;// 在ActorMapper上添加@Repository注解即可消除IDEA报错。但实际上不加，运行时也不会出现异常。

    @Test
    public void testPagination() {
        // liuyang 20220325 实测：因为标注是标在了service上，所以直接掉mapper貌似数据源切换不起效。
        //                  解决：把@DS注解到Mapper接口上即可
        Page<Actor> page = new Page<>(2, 5);
        actorMapper.selectPage(page, Wrappers.<Actor>lambdaQuery().orderByAsc(Actor::getActorId));
        page.getRecords().stream().forEach(System.out::println);
        page.getCurrent();// 当前页码
        page.getSize();// 当前页条数
        page.getPages();// 总页数
        page.getTotal();// 总记录数
        page.hasNext();
        page.hasPrevious();
    }
}
