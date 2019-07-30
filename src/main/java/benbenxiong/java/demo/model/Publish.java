package benbenxiong.java.demo.model;

import lombok.Data;

@Data
public class Publish {
    private long id;
    private String title;
    private String desc;
    private String lab;
    private int scanNum;
    private int likeNum;
    private int attentionNum;
    private int replyNum;
    private long   createdAt;
    private long   updatedAt;


}
