package liuyang.testdatambp.modules.actoridsnowflake.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import liuyang.testdatambp.modules.actoridsnowflake.entity.ActorIdSnowflake;
import liuyang.testdatambp.modules.actoridsnowflake.service.ActorIdSnowflakeService;
import liuyang.testdatambp.modules.actoridsnowflake.mapper.ActorIdSnowflakeMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyang(wx)
* @description 针对表【actor_id_snowflake】的数据库操作Service实现
* @createDate 2022-05-18 10:45:58
*/
@DS("sakila")
@Service
public class ActorIdSnowflakeServiceImpl extends ServiceImpl<ActorIdSnowflakeMapper, ActorIdSnowflake>
    implements ActorIdSnowflakeService{

}




