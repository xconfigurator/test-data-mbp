package liuyang.testdatambp.modules.actor.generator.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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

}




