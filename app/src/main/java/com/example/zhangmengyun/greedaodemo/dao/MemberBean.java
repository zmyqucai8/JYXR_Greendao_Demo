package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 * 房间成员
 */
@Entity
public class MemberBean {
    @Id
    private Long id;
    @Index(unique = true)
    private String userId;
    private String imId;
    private String nickName;
    private String avatarUrl;
    private int memebrType; //在当前room的身份
    private String phoneNum;
    private String postName;//岗位名称



    private String accountUserId;


    @Override
    public String toString() {
        return "MemberBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", imId='" + imId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", memebrType=" + memebrType +
                ", phoneNum='" + phoneNum + '\'' +
                ", postName='" + postName + '\'' +
                ", roomId='" + roomId + '\'' +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    //属于这个房间下的
    private String roomId;
    //成员在当前room中显示的标签名称.
    private String tagName;

    @Generated(hash = 934817145)
    public MemberBean(Long id, String userId, String imId, String nickName,
            String avatarUrl, int memebrType, String phoneNum, String postName,
            String accountUserId, String roomId, String tagName) {
        this.id = id;
        this.userId = userId;
        this.imId = imId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.memebrType = memebrType;
        this.phoneNum = phoneNum;
        this.postName = postName;
        this.accountUserId = accountUserId;
        this.roomId = roomId;
        this.tagName = tagName;
    }

    @Generated(hash = 1592035565)
    public MemberBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImId() {
        return this.imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getMemebrType() {
        return this.memebrType;
    }

    public void setMemebrType(int memebrType) {
        this.memebrType = memebrType;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPostName() {
        return this.postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getAccountUserId() {
        return this.accountUserId;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId;
    }

}
