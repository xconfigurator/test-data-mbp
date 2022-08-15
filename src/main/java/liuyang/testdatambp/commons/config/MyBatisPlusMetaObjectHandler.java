package liuyang.testdatambp.commons.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自动填充字段
 *
 * 部署：
 * 1. 复制本组件到工程中。
 * 2. 从容器中注销MybatisInterceptor。
 * 3. entity的对应字段添加@TableField对应注解。
 *
 * @author liuyang(wx)
 * @since 2022/7/14
 * @modify 2022/7/19 liuyang LocalDateTime.now()修改为java.util.Date
 *         2022/8/10 liuyang 1. 调整日志级别
 *                           2. 调整IAM异常识别默认填充值
 */
@Component
@Slf4j
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final String IAMCLIENT_IOEXCEPTION_DEFAULT_USERID = "";// 这些异常值需要在后续
    private static final String IAMCLIENT_IOEXCEPTION_DEFAULT_USERNAME = "IamClientTool IOException";
    private static final String IAMCLIENT_IAMSDKEXCEPTION_DEFAULT_USERID = "";
    private static final String IAMCLIENT_IAMSDKEXCEPTION_DEFAULT_USERNAME = "IamClientTool IamSDKException";
    private static final String IAMCLIENT_IAMEXCEPTION_DEFAULT_USERID = "";// 20220810 实测 由于设备上报时没有鉴权，故会有大量值入库，20220810经负责人同意暂时置空。
    private static final String IAMCLIENT_IAMEXCEPTION_DEFAULT_USERNAME = "";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 20220815 test
        if (metaObject.hasSetter("name")) {
            this.strictInsertFill(metaObject, "name", String.class, "name from autofill insert");
        }


        // create_time
        if (metaObject.hasSetter("createTime")) {
            //setInsertFieldValByName("createTime", new Date(), metaObject);
            // this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        }

        // create_user_id && create_user_name
        // 为减少非必要调用IAM次数并容错(编码并不能假设实体都必须同时拥有这两个字段，虽然现在这四个表确实都是同时含有这两个字段的)
        boolean hasCreateUserId = metaObject.hasSetter("createUserId");
        boolean hasCreateUsername = metaObject.hasSetter("createUsername");
        if (hasCreateUserId || hasCreateUsername) {
            //IamUserWrapper iamUserWrapper = getUserInfo();
            if (hasCreateUserId) {
                //setInsertFieldValByName("createUserId", iamUserWrapper.getAccount(), metaObject);
            }
            if (hasCreateUsername) {
                //setInsertFieldValByName("createUsername", iamUserWrapper.getName(), metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 20220815 test
        if (metaObject.hasSetter("name")) {
            this.strictUpdateFill(metaObject, "name", String.class, "foo from autofill update");
        }


        // update_time
        if (metaObject.hasSetter("updateTime")) {
            //setUpdateFieldValByName("updateTime", new Date(), metaObject);
        }

        // update_user_id && update_user_name
        // 为减少非必要调用IAM次数并容错(编码并不能假设实体都必须同时拥有这两个字段，虽然现在这四个表确实都是同时含有这两个字段的)
        boolean hasUpdateUserId = metaObject.hasSetter("updateUserId");
        boolean hasUpdateUsername = metaObject.hasSetter("updateUsername");
        if (hasUpdateUserId || hasUpdateUsername) {
            //IamUserWrapper iamUserWrapper = getUserInfo();
            if (hasUpdateUserId) {
                //setUpdateFieldValByName("updateUserId", iamUserWrapper.getAccount(), metaObject);
            }
            if (hasUpdateUsername) {
                //setUpdateFieldValByName("updateUsername", iamUserWrapper.getName(), metaObject);
            }
        }
    }

    /**
     * 通过IAM拿到当前用户信息
     * 如果同IAM
     *
     * @return 用户信息
     */
    /*
    private IamUserWrapper getUserInfo() {
        IamUserWrapper iamUserWrapper = new IamUserWrapper();
        try {
            iamUserWrapper = IamClientTool.getCurrentUserInfo();
            return iamUserWrapper;
        } catch (IOException ioException) {
            log.error(ioException.getMessage(), ioException);
            iamUserWrapper.setAccount(IAMCLIENT_IOEXCEPTION_DEFAULT_USERID);
            iamUserWrapper.setName(IAMCLIENT_IOEXCEPTION_DEFAULT_USERNAME);
            return iamUserWrapper;
        } catch (IamSDKException e) {
            log.error(e.getMessage(), e);
            iamUserWrapper.setAccount(IAMCLIENT_IAMSDKEXCEPTION_DEFAULT_USERID);
            iamUserWrapper.setName(IAMCLIENT_IAMSDKEXCEPTION_DEFAULT_USERNAME);
            return iamUserWrapper;
        } catch (IamException e) {
            log.error(e.getMessage(), e);
            iamUserWrapper.setAccount(IAMCLIENT_IAMEXCEPTION_DEFAULT_USERID);
            iamUserWrapper.setName(IAMCLIENT_IAMEXCEPTION_DEFAULT_USERNAME);
            return iamUserWrapper;
        }
    }
     */
}
