package benbenxiong.java.demo.model;

import lombok.Data;

@Data
public class Publish {
    private int id;
    private String title;
    private String desc;
    private String lab;
    private int uid;
    private int scanNum;
    private int likeNum;
    private int attentionNum;
    private int replyNum;
    private long   createdAt;
    private long   updatedAt;


}
