package liuyang.testdatambp.modules.actor.generator.mapper;

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
}




