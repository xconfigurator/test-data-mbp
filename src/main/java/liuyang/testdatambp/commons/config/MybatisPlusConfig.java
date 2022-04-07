package liuyang.testdatambp.commons.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyang(wx)
 * @since 2022/3/25
 */
@Configuration
@MapperScans({
        @MapperScan("liuyang.testdatambp.modules.user.generated.mapper")
        , @MapperScan("liuyang.testdatambp.modules.actor.generator.mapper")
})
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件 (不需要额外加pom.xml依赖)
        // doc: https://baomidou.com/pages/97710a/
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 乐观锁插件（不需要额外加pom.xml依赖）
        // doc: https://baomidou.com/pages/0d93c0/
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

}
