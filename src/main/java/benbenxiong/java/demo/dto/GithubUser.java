package benbenxiong.java.demo.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;  //用户名
    private long id;       //github id
    private String bio;     //个人说明
    private String avatar_url;    //用户头像

}
