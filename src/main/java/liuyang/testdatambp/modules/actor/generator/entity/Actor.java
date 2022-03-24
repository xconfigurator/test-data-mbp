package liuyang.testdatambp.modules.actor.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName actor
 */
@TableName(value ="actor")
public class Actor implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer actorId;

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

    /**
     * 
     */
    public Integer getActorId() {
        return actorId;
    }

    /**
     * 
     */
    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    /**
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Actor other = (Actor) that;
        return (this.getActorId() == null ? other.getActorId() == null : this.getActorId().equals(other.getActorId()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActorId() == null) ? 0 : getActorId().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actorId=").append(actorId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}