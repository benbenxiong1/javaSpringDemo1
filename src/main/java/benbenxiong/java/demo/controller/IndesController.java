package benbenxiong.java.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndesController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
