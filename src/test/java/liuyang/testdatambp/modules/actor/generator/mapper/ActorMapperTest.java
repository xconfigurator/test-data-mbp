package liuyang.testdatambp.modules.actor.generator.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

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
        // IntelliJ 快捷键
        // 光标移到Page上， Ctrl + H 或者光标选中IPage-->右键-->Diagrams-->Show Diagram Popup...
        // 光标移到Page上， Ctrl + P
        // 光标移到Page上， Ctrl + Alt + Shift + u 有惊喜。
        //Page<Actor> page = new Page<>(2, 5);// current: 当前页页码，size:每页显示条数。详细参见代码注释。
        //Page<Actor> page = new Page<>(1, 5);// current: 当前页页码，size:每页显示条数。详细参见代码注释。
        Page<Actor> page = new Page<>(3, 5);
        actorMapper.selectPage(page, Wrappers.<Actor>lambdaQuery().orderByAsc(Actor::getActorId));
        page.getRecords().stream().forEach(System.out::println);
        page.getCurrent();// 当前页码
        page.getSize();// 当前页条数
        page.getPages();// 总页数
        page.getTotal();// 总记录数
        page.hasNext();
        page.hasPrevious();
    }

    @Test
    public void testPaginationCustomization() {
        Page<Actor> page = new Page<>(1, 200);
        actorMapper.selectPageActorVOCustomize(page, "GUINESS");// E
        page.getRecords().stream().forEach(System.out::println);
    }

    // /////////////////////////////////////////////////////
    // BaseMapper API
    @Test
    void testSelect() {
        // 没写SQL，但直接可以用！！
        actorMapper.selectList(null).stream().forEach(System.out::println);
    }

    @Test
    void testSelectWithJavaStreamAPI() {
        Optional<Actor> max = actorMapper.selectList(null).stream().max(Comparator.comparing(Actor::getActorId));
        if (max.isPresent()) {
            System.out.println(max.get().getActorId());
            System.out.println(max.get());
        }
    }

    @Test
    void testInsert() {
        Actor actor = new Actor();
        // 【关于主键】 表格该字段是 `actor_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT
        // 1. 不需要设置
        // 2. 如果设置了就按照设置的值入库
        //actor.setActorId(444); // ok
        // 注：实测（202205181029）如果插入了444这条记录，后面的记录不设置主键值，则新增记录的ID是445。
        actor.setFirstName("yang");
        actor.setLastName("liu");
        actor.setLastUpdate(new Date());
        int insert = actorMapper.insert(actor);// 影响记录数
        log.info("影响记录数：insert = {}", insert);
        log.info("自增主键值：actorId = {}", actor.getActorId());// 【关于获得自增主键值】实测，可以获得自增主键值。
    }

    // 后续例子参考ActorIdSnowflakeMapperTest.java
}
