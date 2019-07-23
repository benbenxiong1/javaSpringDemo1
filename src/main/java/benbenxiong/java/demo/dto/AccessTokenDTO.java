package benbenxiong.java.demo.dto;

public class AccessTokenDTO {
    private String client_id;     //应用程序id
    private String client_secret;  //应用程序的加密信息
    private String code;           //返回的code
    private String redirect_uri; //应用程序中的URL，用于在授权后发送用户。
    private String state;        //随机字符串

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
