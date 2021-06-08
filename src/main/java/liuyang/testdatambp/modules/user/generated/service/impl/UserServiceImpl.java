package liuyang.testdatambp.modules.user.generated.service.impl;

import liuyang.testdatambp.modules.user.generated.entity.User;
import liuyang.testdatambp.modules.user.generated.mapper.UserMapper;
import liuyang.testdatambp.modules.user.generated.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuyang
 * @since 2021-06-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
