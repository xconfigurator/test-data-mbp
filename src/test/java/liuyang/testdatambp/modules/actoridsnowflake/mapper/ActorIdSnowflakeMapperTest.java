package liuyang.testdatambp.modules.actoridsnowflake.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import liuyang.testdatambp.modules.actoridsnowflake.entity.ActorIdSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 参考文档：
 * https://www.mybatis-plus.com/guide/crud-interface.html#mapper-crud-%E6%8E%A5%E5%8F%A3
 * @author liuyang(wx)
 * @since 2022/5/18
 */
@SpringBootTest
@Slf4j
public class ActorIdSnowflakeMapperTest {

    @Autowired
    private ActorIdSnowflakeMapper mapper;

    // 增
    @Test
    @RepeatedTest(16)
    void testInsert() {
        ActorIdSnowflake entity = new ActorIdSnowflake();
        // 【关于主键】
        // 1. @TableId。 MyBatis-Plus会默认使用雪花算法
        // 2. 如果指定会怎样？
        // 就用指定的值。
        // 这个比数据库自增明确，无论是雪花算法生成的还是单元测试中手动指定的，全部都可归类为“外部指定的”。
        //actorIdSnowflake.setActorId(999l);
        entity.setFirstName("yang");
        entity.setLastName("liu");
        entity.setLastUpdate(new Date());
        int insert = mapper.insert(entity);
        log.info("影响记录数：insert = {}", insert);
        log.info("自增主键值：actorId = {}", entity.getActorId());// 【关于获得自增主键值】实测，可以获得自增主键值。
    }

    // 删
    @Test
    void testDeleteById() {
        int i = mapper.deleteById(1526762124048674818l);
        log.info("影响记录数：i = {}", i);
    }

    @Test
    void testDeleteBatchIds() {
        List<Long> ids = Arrays.asList(1526763199011028994l,
                1526767238117400578l,
                1526767239220502529l);
        int i = mapper.deleteBatchIds(ids);
        log.info("影响记录数：i = {}", i);
    }

    @Test
    void testDeleteByMap() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> param = new HashMap<>();
        param.put("last_update", sdf.parse("2022-05-18 11:30:51"));// 注意这个时间值，应与库汇总的记录对应
        param.put("actor_id", 0l);
        int i = mapper.deleteByMap(param);
        log.info("影响记录数：i = {}", i);
        Assertions.assertEquals(0, i);// 影响0行, 因为这个表中肯定没有actor_id = 0的这条记录

        param.put("actor_id", 1526767239589601282l);
        int i2 = mapper.deleteByMap(param);
        log.info("影响记录数：i2 = {}", i2);
    }

    @Test
    void testDeleteById2() {
        ActorIdSnowflake entity = new ActorIdSnowflake();
        entity.setActorId(1526795959884910593l);

        int i = mapper.deleteById(entity);
        log.info("影响记录数：i = {}", i);
    }

    @Test
    void testDelete() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        LambdaUpdateWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaUpdateWrapper = Wrappers.<ActorIdSnowflake>lambdaUpdate();
        actorIdSnowflakeLambdaUpdateWrapper.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 13:33:00"));
        int i = mapper.delete(actorIdSnowflakeLambdaUpdateWrapper);
        log.info("影响记录数：i = {}", i);
    }

    // 改
    @Test
    void testUpdateById() {
        ActorIdSnowflake entity = new ActorIdSnowflake();
        entity.setActorId(1526799147660779521l);
        entity.setFirstName("yang++");
        // 其他的字段值不会变！

        int i = mapper.updateById(entity);
        log.info("影响记录数：i = {}", i);
    }

    @Test
    void testUpdate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ActorIdSnowflake entity = new ActorIdSnowflake();
        entity.setFirstName("yang++--");

        LambdaUpdateWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaUpdateWrapper = Wrappers.<ActorIdSnowflake>lambdaUpdate();
        actorIdSnowflakeLambdaUpdateWrapper.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 13:37:38"));
        // 其实LambdaWrapper还可以携带需要修改的字段。
        //actorIdSnowflakeLambdaUpdateWrapper.set()

        int i = mapper.update(entity, actorIdSnowflakeLambdaUpdateWrapper);
        log.info("影响记录数：i = {}", i);
    }

    // 可以通过UpdateWrapper直接设置需要修改的值。这个感觉有点别扭。推荐还是用上面的方法。
    @Test
    void testUpdateUpdateDataViaUpdateWrapper() {
        LambdaUpdateWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaUpdateWrapper = Wrappers.<ActorIdSnowflake>lambdaUpdate();
        actorIdSnowflakeLambdaUpdateWrapper.eq(ActorIdSnowflake::getActorId, 1526799147463647234l);
        actorIdSnowflakeLambdaUpdateWrapper.set(ActorIdSnowflake::getFirstName, "yang++-- via UpdateWrapper");
        // 注意用法
        int update = mapper.update(null, actorIdSnowflakeLambdaUpdateWrapper);
        log.info("影响记录数 = {}", update);
    }

    // 查
    @Test
    void testSelectCount() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 13:33:00"));

        Long count = mapper.selectCount(actorIdSnowflakeLambdaQueryWrapper);
        log.info("count = {}", count);
    }

    @Test
    void testSelectOne() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 05:56:03"));// 只有一条的

        // 【单条】
        ActorIdSnowflake actorIdSnowflake = mapper.selectOne(actorIdSnowflakeLambdaQueryWrapper);
        Assertions.assertEquals(1526799147660779521l, actorIdSnowflake.getActorId());

        // 【一定有多条, 会抛出异常】
        Assertions.assertThrows(Exception.class, () -> {
            LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper2 = Wrappers.<ActorIdSnowflake>lambdaQuery();
            actorIdSnowflakeLambdaQueryWrapper2.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 05:59:37"));
            ActorIdSnowflake actorIdSnowflake2 = mapper.selectOne(actorIdSnowflakeLambdaQueryWrapper2);
            log.info("actorIdSnowflake1 = {}", actorIdSnowflake2);
        });
    }

    @Test
    void testExists() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.eq(ActorIdSnowflake::getLastUpdate, sdf.parse("2022-05-18 13:37:38"));

        boolean exists = mapper.exists(actorIdSnowflakeLambdaQueryWrapper);
        log.info("exists = {}", exists);
    }

    @Test
    void testSelectPage() {
        Page<ActorIdSnowflake> page = new Page<>(1, 10);
        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.orderByDesc(ActorIdSnowflake::getActorId);

        Page<ActorIdSnowflake> actorIdSnowflakePage = mapper.selectPage(page, actorIdSnowflakeLambdaQueryWrapper);
        actorIdSnowflakePage.getRecords().stream().forEach(System.out::println);
        log.info("page.getCurrent() = {}", page.getCurrent());// 当前页码
        log.info("page.getSize() = {}", page.getSize());// 当前页条数
        log.info("page.getPages() = {}", page.getPages());// 总页数
        log.info("page.getTotal() = {}", page.getTotal());// 总记录数
        log.info("page.hasPrevious() = {}", page.hasPrevious());
        log.info("page.hasNext() = {}", page.hasNext());
    }

    @Test
    void testSelectList() {
        // 条件构造器传null就是查询所有
        mapper.selectList(null).stream().forEach(System.out::println);
    }

    // 投影
    // 条件构造器.select() 配合 mapper.selectMaps 非常方便！
    @Test
    void testSelectMaps() {
        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.select(ActorIdSnowflake::getActorId, ActorIdSnowflake::getFirstName);

        List<Map<String, Object>> maps = mapper.selectMaps(actorIdSnowflakeLambdaQueryWrapper);
        maps.stream().limit(5).forEach(System.out::println);
    }

    // 演示一个子查询
    // 需求：列出actorId < 10的用户信息
    @Test
    void testSelectListSubquery() {
        // 注：使用子查询的场景可以考虑优先使用*Mapper.xml的方案。
        LambdaQueryWrapper<ActorIdSnowflake> actorIdSnowflakeLambdaQueryWrapper = Wrappers.<ActorIdSnowflake>lambdaQuery();
        actorIdSnowflakeLambdaQueryWrapper.inSql(ActorIdSnowflake::getActorId, "select actor_id from actor_id_snowflake where actor_id <= 10");// 注意，如果自己写SQL需要考虑到逻辑删除字段，则框架不再自动处理。没有逻辑删除需求则忽略即可。

        List<ActorIdSnowflake> actorIdSnowflakes = mapper.selectList(actorIdSnowflakeLambdaQueryWrapper);
        actorIdSnowflakes.stream().forEach(System.out::println);
    }
}
