package benbenxiong.java.demo.provider;

import benbenxiong.java.demo.dto.AccessTokenDTO;
import benbenxiong.java.demo.dto.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvier {
    private String url = "https://github.com/login/oauth/access_token";

    /**
     * 获取用户token
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");  //设置请求格式

        OkHttpClient client = new OkHttpClient();   //实例化

        String accessTokenJson = JSON.toJSONString(accessTokenDTO);   //对象转json

        RequestBody body = RequestBody.create(mediaType, accessTokenJson);   //设置请求参数
        Request request = new Request.Builder()
                    .url(this.url)
                    .post(body)
                    .build();
        try (Response response = client.newCall(request).execute()) {
            String resData =  response.body().string();
            //返回的字符串需要进行拆分access_token=1794e5b306f5e6deaa24428e4efc660bfe178504&scope=&token_type=bearer
            String[] strArr = resData.split("&");
            String token = strArr[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据token获取用户信息
     * @param accessToken
     * @return
     */
    public GithubUser getGithubUser(String accessToken){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
        try (Response response = client.newCall(request).execute()) {
            String resData = response.body().string();
            GithubUser user = JSON.parseObject(resData, GithubUser.class);  //json转java对象
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }



}
