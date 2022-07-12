package liuyang.testdatambp.modules.actor;

import com.alibaba.fastjson.JSONObject;
import liuyang.testdatambp.commons.utils.HttpClientUtil;
import liuyang.testdatambp.modules.actor.generator.entity.Actor;
import liuyang.testdatambp.modules.actor.generator.mapper.ActorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author liuyang(wx)
 * @since 2022/6/24
 */
@Service
@Slf4j
public class TxService {

    @Autowired
    private ActorMapper actorMapper;// 在ActorMapper上添加@Repository注解即可消除IDEA报错。但实际上不加，运行时也不会出现异常。

    @Transactional
    public void foo() {
        insert();
        insert();

        // http
        StringBuilder url = new StringBuilder();
        url.append("https://10.10.9.18:3002/requestService/operator/userlogin?udpID=123&Name=hssuser&Password=hssuser&isForceLogin=1");
        JSONObject jsonObject = HttpClientUtil.get2(url.toString());
        log.info("jsonObject {}", jsonObject);
    }


    private void insert() {
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
        log.info("自增主键值：actorId = {}", actor.getActorId());// 【关于获得自增主键值】实测，可以获得自增主键值。（应该是MyBatis-Plus配置好的）
    }
}
