package benbenxiong.java.demo.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private String url;
    private long   createdAt;
    private long   updatedAt;
}
