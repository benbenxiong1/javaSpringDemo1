package benbenxiong.java.demo.mapper;

import benbenxiong.java.demo.model.Publish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PublishMapper {

    @Insert("insert into publish (`title`,`desc`,`lab`,`created_at`,`updated_at`) values (#{title},#{desc},#{lab},#{createdAt},#{updatedAt})")
    void insert(Publish publish);

}
