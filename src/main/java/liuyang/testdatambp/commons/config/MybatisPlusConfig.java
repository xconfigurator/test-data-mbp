package liuyang.testdatambp.commons.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import net.bytebuddy.implementation.bind.annotation.FieldProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author liuyang(wx)
 * @since 2022/3/25
 */
@Configuration
// 包扫描方法1: ok
/*
@MapperScans({
        @MapperScan("liuyang.testdatambp.modules.user.generated.mapper")
        , @MapperScan("liuyang.testdatambp.modules.actor.generator.mapper")
        , @MapperScan("liuyang.testdatambp.modules.multitablequery.mapper")
        , @MapperScan("liuyang.testdatambp.modules.actoridsnowflake.mapper")
})
 */
// 包扫描方法2：另一个参考的写法@MapperScan("foo.bar.**.mapper")
@MapperScan("liuyang.testdatambp.modules.**.mapper")// 20220525 ok
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件 (不需要额外加pom.xml依赖)
        // doc: https://baomidou.com/pages/97710a/
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 乐观锁插件（不需要额外加pom.xml依赖） + @Version （如果冲突，第二条不会被执行，可以通过更新语句返回的影响条数来进行判断）
        // doc: https://baomidou.com/pages/0d93c0/
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // sql性能规范
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        return interceptor;
    }

    // 性能分析插件，开发调试环境使用(新版本已改为“sql性能规范 IllegalSQLInnerInterceptor”)
    /*
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // maxTime 指的是 sql 最大执行时长
        final int maxTime = 5000;
        performanceInterceptor.setMaxTime(maxTime);
        //SQL是否格式化 默认false
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
     */
}
