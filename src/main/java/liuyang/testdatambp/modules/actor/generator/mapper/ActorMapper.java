package liuyang.testdatambp.modules.actor.generator.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author xconf
* @description 针对表【actor】的数据库操作Mapper
* @createDate 2022-03-24 23:18:34
* @Entity liuyang.testdatambp.modules.actor.generator.entity.Actor
*/
@DS("sakila")
@Repository
//@Mapper
public interface ActorMapper extends BaseMapper<Actor> {

    // 如果分页是一个自定义的SQL，如何使用MyBatis-Plus分页插件？
    // https://baomidou.com/pages/97710a/#paginationinnerinterceptor
    // SQL语句中不需要使用page，但如果想在自定义的SQL语句中使用分页插件，那么第一个参数就必须是IPage。
    // 1. 参考视频 尚硅谷2022 44 - 自定义分页功能
    //            三更草堂2021 23 单表分页查询 24、25 多表分页查询
    // 2. MyBatisX插件： step1：写方法名(命名约定) step2：Alt + Enter。
    //      MybatisX https://baomidou.com/pages/ba5b24/ 有一些命名约定 联想一下Spring Data JPA的相关内容。
    //      借助MybatisX，可以提供类似使用Spring Data JPA的体验。
    // 3. IntelliJ 快捷键 Alt + Enter 有惊喜！ 只写一个方法名 再按Alt + Enter
    IPage<Actor> selectPageActorVOCustomize(@Param("page") IPage<?> page, String lastName);

    // 通过MybatisX生成
    // 问题：忘了动态SQL怎么办？
    // 答：（生成有选择性地添加语句）
    // step1：写方法名insert, 根据MybatisX插件提示选择insertSelective
    // step2：双击选中insertSelective（不用选中，挪到上面即可），并右键选择 [MybatisX] Generate Mybatis Sql
    // step3：查看映射文件ActorMapper.xml文件。有惊喜。
    int insertSelective(Actor actor);

    // 通过MybatisX生成
    int deleteByActorId(@Param("actorId") Integer actorId);

    int deleteInBatch(@Param("actorIds") List<Integer> actorIds);

    // 通过MybatisX生成
    int updateFirstNameByActorId(@Param("firstName") String firstName, @Param("actorId") Integer actorId);

    // 通过MybatisX生成
    // 貌似这个like生成的有点问题。
    List<Actor> selectByLastNameLike(@Param("lastName") String lastName);

    // 通过MybatisX生成
    List<Actor> selectAllByLastUpdateBetween(@Param("beginLastUpdate") Date beginLastUpdate, @Param("endLastUpdate") Date endLastUpdate);

    // 通过MybatisX生成
    List<Actor> selectAllOrderByLastName();

    // 聚合查询
    int countByActorId();

    // 投影
    // 若不指定@MapKey，IntelliJ会报错，但不影响程序运行
    //@MapKey("actor_idx")// 20220614 写成这样运行都不报错，这个@MapKey到底啥用途？
    @MapKey("actor_id")
    // 经测，貌似这个加不加@MapKey以及标注的的@MapKey是什么内容没有什么区别。
    List<Map<String, Object>> selectProjection();

    // 投影
    // 若不指定@MapKey，IntelliJ会报错，但不影响程序运行
    //@MapKey("actor_idxx")// 20220614 写成这样运行都不报错，这个@MapKey到底啥用途？ 看运行结果就知道
    @MapKey("actor_id")
    Map<String, Object> selectProjectionById(@Param("actorId") int actorId);
    //@MapKey("actor_idxx")
    // 2022-06-14 17:38:02.680  INFO 12596 --- [           main] l.t.m.a.g.mapper.ActorMapperTest         : result = {null={last_update=2006-02-15 04:34:33.0, actor_id=1}}
    //@MapKey("actor_id")
    // 2022-06-14 17:36:35.165  INFO 9500 --- [           main] l.t.m.a.g.mapper.ActorMapperTest         : result = {1={last_update=2006-02-15 04:34:33.0, actor_id=1}}

    // 投影
    // 运行一下这个方法的单测，看一下返回就知道@MapKey到底是干啥的了
    //@MapKey("actor_idx")// 运行时并不抛异常
    @MapKey("actor_id")// ok
    Map<String, Object> selectProjectionMapKey();
}




