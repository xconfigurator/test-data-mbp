package liuyang.testdatambp.modules.multitablequery.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import liuyang.testdatambp.modules.multitablequery.entity.ActorFilm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liuyang(wx)
 * @since 2022/4/8
 */
@SpringBootTest
@Slf4j
public class ActorFilmMapperTest {

    @Autowired
    private ActorFilmMapper actorFilmMapper;

    // 不带条件多表联查
    @Test
    void testPagination() {
        IPage<ActorFilm> page = new Page<>(1, 50);
        actorFilmMapper.selectAllPagination(page);
        page.getRecords().stream().forEach(System.out::println);
    }

    // 带条件多表联查
    @Test
    void testPaginationCondition() {
        IPage<ActorFilm> page = new Page<>(1, 100);
        actorFilmMapper.selectAllPaginationCondition(page, "GUINESS");//GUINESS CHASE
        page.getRecords().stream().forEach(System.out::println);
        log.info("page.getTotal() =  {}", page.getTotal());// 这个总记录数貌似有点问题？！ 202204081649
        log.info("page.getRecords().size() = {}", page.getRecords().size());
    }
}
