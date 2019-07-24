package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.dto.AccessTokenDTO;
import benbenxiong.java.demo.dto.GithubUser;
import benbenxiong.java.demo.provider.GithubProvier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvier.getAccessToken(accessTokenDTO);

        GithubUser githubUser = githubProvier.getGithubUser(accessToken);

        System.out.println(githubUser.toString());

        return "index";
    }


}
