package benbenxiong.java.demo.dto;

import benbenxiong.java.demo.model.User;
import lombok.Data;

@Data
public class PublishDTO {
    private long id;
    private String title;
    private String desc;
    private String lab;
    private int uid;
    private int scanNum;
    private int likeNum;
    private int attentionNum;
    private int replyNum;
    private long createdAt;
    private long updatedAt;
    private User user;
}
