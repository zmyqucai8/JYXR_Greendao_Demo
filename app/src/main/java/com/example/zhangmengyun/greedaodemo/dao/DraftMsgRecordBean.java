package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 * 草稿消息记录表
 */

@Entity
public class DraftMsgRecordBean {

    @Id
    private Long id;
    @Index(unique = true)
    private String imId;
    private String userId;
    private String content;
    private long time;
    @Generated(hash = 210620587)
    public DraftMsgRecordBean(Long id, String imId, String userId, String content,
            long time) {
        this.id = id;
        this.imId = imId;
        this.userId = userId;
        this.content = content;
        this.time = time;
    }
    @Generated(hash = 215186406)
    public DraftMsgRecordBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImId() {
        return this.imId;
    }
    public void setImId(String imId) {
        this.imId = imId;
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
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DraftMsgRecordBean{" +
                "id=" + id +
                ", imId='" + imId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
