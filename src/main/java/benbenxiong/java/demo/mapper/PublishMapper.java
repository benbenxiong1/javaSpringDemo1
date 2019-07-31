package benbenxiong.java.demo.mapper;

import benbenxiong.java.demo.model.Publish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PublishMapper {

    @Insert("insert into publish (`title`,`desc`,`lab`,`created_at`,`updated_at`,`uid`) values (#{title},#{desc},#{lab},#{createdAt},#{updatedAt},#{uid})")
    void insert(Publish publish);

    @Select("select * from publish order by `updated_at` desc")
    List<Publish> get();

}
