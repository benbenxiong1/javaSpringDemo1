package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.dto.PublishDTO;
import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.User;
import benbenxiong.java.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PublishService publishService;

    @GetMapping("/")
    public String publish(HttpServletRequest request,
                          Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<PublishDTO> publishList = publishService.getPublish();
        model.addAttribute("publishList",publishList);
        return "index";
    }

}
