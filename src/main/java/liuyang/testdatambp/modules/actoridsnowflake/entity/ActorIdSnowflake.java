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
     * 1. MyBatis-Plus默认会将id字段作为主键。如果表中并没有id字段，则需要使用@TableId注解告诉MyBatis-Plus，哪个是主键。
     * 2. 若数据库的名称与entity属性不同，可以使用@TableId的value属性予以映射。
     * 3. 实测默认@TableId的type默认为IdType.ASSIGN_ID即雪花算法。
     *    若数据库中为自增，需要 @TableId(type = IdType.AUTO)
     */
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