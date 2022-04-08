package liuyang.testdatambp.modules.multitablequery.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author liuyang(wx)
 * @since 2022/4/8
 */
@Data
public class ActorFilm {
    // Actor
    //@TableId(type = IdType.AUTO)
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    // Film
    private String title;
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
