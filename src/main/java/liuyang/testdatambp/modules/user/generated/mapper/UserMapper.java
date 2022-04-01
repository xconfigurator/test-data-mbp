package liuyang.testdatambp.modules.user.generated.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import liuyang.testdatambp.modules.user.generated.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuyang
 * @since 2021-06-08
 */
@DS("test")
@Mapper// 202204011108 非必须，但可以消除单元测试中注入时的警告
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User selectUserById(Long id);

    //@Update("UPDATE user SET name = #{user.name}, age = #{user.age}, email = #{user.email} WHERE id = #{user.id}")
    @Update("UPDATE user SET name = #{name}, age = #{age}, email = #{email} WHERE id = #{id}")
    public void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    public void deleteUserById(Long id);

    @Insert("INSERT INTO user(id, name, age, email) VALUES (#{id}, #{name}, #{age}, #{email})")
    public void insertUser(User user);
}
