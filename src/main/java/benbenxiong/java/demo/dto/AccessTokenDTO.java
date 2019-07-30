package benbenxiong.java.demo.dto;

import lombok.Data;

@Data
public class AccessTokenDTO {
    private String client_id;     //应用程序id
    private String client_secret;  //应用程序的加密信息
    private String code;           //返回的code
    private String redirect_uri; //应用程序中的URL，用于在授权后发送用户。
    private String state;        //随机字符串
}
