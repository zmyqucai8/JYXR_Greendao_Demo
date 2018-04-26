package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 *
 * 消息主页 记录表
 */

@Entity
public class MessageBean {



    @Id
    private Long id;
    @Index(unique = true)
    private String msgId;
    private String title;
    private String avatarUrl;
    private String userId;
    private String content;
    private String count;
    @Generated(hash = 157175638)
    public MessageBean(Long id, String msgId, String title, String avatarUrl,
            String userId, String content, String count) {
        this.id = id;
        this.msgId = msgId;
        this.title = title;
        this.avatarUrl = avatarUrl;
        this.userId = userId;
        this.content = content;
        this.count = count;
    }
    @Generated(hash = 1588632019)
    public MessageBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMsgId() {
        return this.msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAvatarUrl() {
        return this.avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCount() {
        return this.count;
    }
    public void setCount(String count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", title='" + title + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
