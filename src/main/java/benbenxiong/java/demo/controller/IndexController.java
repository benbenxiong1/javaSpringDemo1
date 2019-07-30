package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String publish(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }


        return "index";
    }

}