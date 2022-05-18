package liuyang.testdatambp.modules.actoridsnowflake.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName actor_id_snowflake
 */
@TableName(value ="actor_id_snowflake")
@Data
public class ActorIdSnowflake implements Serializable {
    /**
     * 
     */
    // MyBatis-Plus默认会将id字段作为主键。如果表中并没有id字段，则需要使用@TableId注解告诉MyBatis-Plus，哪个是主键。
    @TableId
    private Long actorId;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String lastName;

    /**
     * 
     */
    private Date lastUpdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}