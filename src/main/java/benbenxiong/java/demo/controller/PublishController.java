package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.mapper.PublishMapper;
import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.Publish;
import benbenxiong.java.demo.model.User;
import benbenxiong.java.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private PublishService publishService;

    @GetMapping("/publish")
    public String publish(HttpServletRequest request) {
        return "publish";
    }

    @PostMapping("/publish")
    public String publish(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "desc") String desc,
            @RequestParam(name = "lab") String lab,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title",title);
        model.addAttribute("desc",desc);
        model.addAttribute("lab",lab);
        if(title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(desc == null || desc == ""){
            model.addAttribute("error","问题描述不能为空");
            return "publish";
        }
        if(lab == null || lab == ""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","用户未登陆");
            return "publish";
        }

        Publish publish = new Publish();
        publish.setTitle(title);
        publish.setDesc(desc);
        publish.setLab(lab);
        publish.setUid(user.getId());
        publish.setCreatedAt(System.currentTimeMillis());
        publish.setUpdatedAt(publish.getCreatedAt());
        System.out.println(publish.toString());
//        publishMapper.insert(publish);
        model.addAttribute("susses","添加成功");

        return "/publish";
    }
}
