package liuyang.testdatambp.modules.actor.generator.mapper;
import java.util.Date;
import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

    // 通过MybatisX生成
    int updateFirstNameByActorId(@Param("firstName") String firstName, @Param("actorId") Integer actorId);

    // 通过MybatisX生成
    // 貌似这个like生成的有点问题。
    List<Actor> selectByLastNameLike(@Param("lastName") String lastName);

    // 通过MybatisX生成
    List<Actor> selectAllByLastUpdateBetween(@Param("beginLastUpdate") Date beginLastUpdate, @Param("endLastUpdate") Date endLastUpdate);

    // 通过MybatisX生成
    List<Actor> selectAllOrderByLastName();
}




