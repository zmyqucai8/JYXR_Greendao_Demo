package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 * 文件消息记录表
 */
@Entity
public class FileMsgRecordBean {
    @Id
    private Long id;
    @Index(unique = true)
    private String msgId;
    private String imId;
    private String userId;
    private String fileName;
    private String filePath;
    @Generated(hash = 1337007769)
    public FileMsgRecordBean(Long id, String msgId, String imId, String userId,
            String fileName, String filePath) {
        this.id = id;
        this.msgId = msgId;
        this.imId = imId;
        this.userId = userId;
        this.fileName = fileName;
        this.filePath = filePath;
    }
    @Generated(hash = 1320119080)
    public FileMsgRecordBean() {
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
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileMsgRecordBean{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", imId='" + imId + '\'' +
                ", userId='" + userId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
