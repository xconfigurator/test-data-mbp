package liuyang.testdatambp.modules.multitablequery.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import liuyang.testdatambp.modules.multitablequery.entity.ActorFilm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liuyang(wx)
 * @since 2022/4/8
 */
@DS("sakila")
@Repository
//@Mapper
public interface ActorFilmMapper extends BaseMapper<ActorFilm> {

    IPage<ActorFilm> selectAllPagination(@Param("page") IPage<?> page);

    IPage<ActorFilm> selectAllPaginationCondition(@Param("page") IPage<?> page, String lastName);
}
