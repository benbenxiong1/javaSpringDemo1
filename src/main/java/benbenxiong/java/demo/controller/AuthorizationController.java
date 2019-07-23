package benbenxiong.java.demo.controller;

import benbenxiong.java.demo.dto.AccessTokenDTO;
import benbenxiong.java.demo.dto.GithubUser;
import benbenxiong.java.demo.provider.GithubProvier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    private String client_id = "7941f9a065825362afcc";
    private String client_secret = "237f5a497cc61393303b28a063ca14439b0770c7";
    @Autowired   //spring自动加载
    private GithubProvier githubProvier;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(this.client_id);
        accessTokenDTO.setClient_secret(this.client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvier.getAccessToken(accessTokenDTO);

        GithubUser githubUser = githubProvier.getGithubUser(accessToken);

        System.out.println(githubUser.toString());

        return "index";
    }


}
