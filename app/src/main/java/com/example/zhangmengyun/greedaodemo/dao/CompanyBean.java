package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangmengyun on 2018/4/25.
 * <p>
 * 我的公司表
 */
@Entity
public class CompanyBean {

    @Id
    private Long id;
    @Index(unique = true)
    private String companyId;
    private String companyName;
    private String companyCode;

    private String userId;

    @Override
    public String toString() {
        return "CompanyBean{" +
                "id=" + id +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Generated(hash = 36746128)
    public CompanyBean(Long id, String companyId, String companyName,
                       String companyCode, String userId) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.userId = userId;
    }

    @Generated(hash = 392445547)
    public CompanyBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
