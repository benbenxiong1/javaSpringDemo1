package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.dto.AccessTokenDTO;
import benbenxiong.java.demo.dto.GithubUser;
import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.User;
import benbenxiong.java.demo.provider.GithubProvier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizationController {

    @Value("${github.client.id}")   //spring自动加载application.properties配置文件下的值
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired   //spring自动加载
    private GithubProvier githubProvier;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state, HttpServletRequest request){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvier.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvier.getGithubUser(accessToken);
        if(githubUser != null){
            User user = new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));  //转换成String类型
            user.setToken(UUID.randomUUID().toString());   //uuid
            user.setCreatedAt(System.currentTimeMillis());
            user.setUpdatedAt(user.getCreatedAt());
            userMapper.insert(user);
            request.getSession().setAttribute("user", githubUser);  //设置session
        }

        return "redirect:/";  //重定向到首页
    }


}
