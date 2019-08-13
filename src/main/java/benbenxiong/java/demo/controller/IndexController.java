package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.dto.PageDTO;
import benbenxiong.java.demo.dto.PublishDTO;
import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.User;
import benbenxiong.java.demo.model.UserExample;
import benbenxiong.java.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "2") Integer size,
                          Model model) {
        PageDTO<PublishDTO> pageList = publishService.getPublish(page,size);
        model.addAttribute("pageList", pageList);
        return "index";
    }

}
