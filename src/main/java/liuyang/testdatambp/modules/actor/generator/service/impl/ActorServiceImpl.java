package liuyang.testdatambp.modules.actor.generator.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import liuyang.testdatambp.modules.actor.generator.service.ActorService;
import liuyang.testdatambp.modules.actor.generator.mapper.ActorMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
* @author xconf
* @description 针对表【actor】的数据库操作Service实现
* @createDate 2022-03-24 23:18:34
*/
@DS("sakila")
@Service
@CacheConfig(cacheNames = {"Actor"})// 202203291320 貌似不太管用
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor>
    implements ActorService{

}




