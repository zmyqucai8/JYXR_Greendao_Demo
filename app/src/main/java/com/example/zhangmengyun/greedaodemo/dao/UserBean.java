package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 *
 * 用户表
 */
@Entity
public class UserBean {


    @Id
    private Long id;


    @NotNull
    @Index(unique = true)
    private String userId;

    private String nickName;
    private String avatarUrl;


    private boolean isFriend;

    private String accountUserId;

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", isFriend='" + isFriend + '\'' +
                ", accountUserId='" + accountUserId + '\'' +
                '}';
    }

    @Generated(hash = 974356308)
    public UserBean(Long id, @NotNull String userId, String nickName,
            String avatarUrl, boolean isFriend, String accountUserId) {
        this.id = id;
        this.userId = userId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.isFriend = isFriend;
        this.accountUserId = accountUserId;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
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

    public String getAccountUserId() {
        return this.accountUserId;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId;
    }

    public boolean getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

}
