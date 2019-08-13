package benbenxiong.java.demo.service;

import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.User;
import benbenxiong.java.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId()); //组合where语句
        List<User> users = userMapper.selectByExample(userExample);  //查询结果
        if(users.size() == 0){
            user.setCreatedAt(System.currentTimeMillis());
            user.setUpdatedAt(user.getCreatedAt());
            userMapper.insert(user);
        }else{
           User dbUser = users.get(0);
           User upUser = new User();
           upUser.setName(user.getName());
           upUser.setUrl(user.getUrl());
           upUser.setToken(user.getToken());
           upUser.setUpdatedAt(System.currentTimeMillis());
           UserExample example = new UserExample();
           example.createCriteria().andIdEqualTo(dbUser.getId());
           userMapper.updateByExampleSelective(upUser,example);
        }

    }


}
