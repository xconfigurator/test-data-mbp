package liuyang.testdatambp;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestDataMbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDataMbpApplication.class, args);
    }

}
