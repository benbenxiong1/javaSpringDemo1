package benbenxiong.java.demo.mapper;

import benbenxiong.java.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,created_at,updated_at) values(#{name},#{accountId},#{token},#{createdAt},#{updatedAt})")
     void insert(User user);
}
