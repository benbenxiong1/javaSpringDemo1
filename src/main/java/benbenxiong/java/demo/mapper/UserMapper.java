package benbenxiong.java.demo.mapper;

import benbenxiong.java.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (`name`,`account_id`,`token`,`created_at`,`updated_at`,`url`) values(#{name},#{accountId},#{token},#{createdAt},#{updatedAt},#{url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findToken(@Param("token") String token);

}
