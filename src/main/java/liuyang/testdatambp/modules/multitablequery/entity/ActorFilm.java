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
    private String description;// 实测可以只接检索结果的部分结果集，注释掉这个字段仍然正常运行测试用例

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
