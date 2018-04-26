package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by zhangmengyun on 2018/4/25.
 * <p>
 * 账户表
 */

@Entity
public class AccountBean {

    @Id
    private Long id;


    @NotNull
    @Index(unique = true)
    private String userId;

    private String nickName;
    private String avatarUrl;

    @Override
    public String toString() {
        return "AccountBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", imId='" + imId + '\'' +
                ", imPwd='" + imPwd + '\'' +
                ", projectList=" + projectList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }

    private String phoneNum;
    private String loginPwd;
    private String imId;
    private String imPwd;


    @Transient
    private List<UserBean> haoYouList;

    //自定义方法
    public List<UserBean> getHaoYouList() {

        if (null == haoYouList) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserBeanDao targetDao = daoSession.getUserBeanDao();
            List<UserBean> userListNew = targetDao.queryBuilder().where(UserBeanDao.Properties.AccountUserId.eq(userId), UserBeanDao.Properties.IsFriend.eq(true)).build().list();
            synchronized (this) {
                if (haoYouList == null) {
                    haoYouList = userListNew;
                }
            }
        }
        return haoYouList;
    }


    //我的项目
//    @ToMany(referencedJoinProperty = "projectId")

    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "userId")
    })
    private List<ProjectBean> projectList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "userId")
    })
    private List<MessageBean> messageList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "userId")
    })
    private List<DraftMsgRecordBean> draftMsgRecordList;


    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "userId")
    })
    private List<FileMsgRecordBean> fileMsgRecordList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "userId")
    })
    private List<CompanyBean> companyList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "userId", referencedName = "accountUserId")
    })
    private List<UserBean> userList;


    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;


    /**
     * Used for active entity operations.
     */
    @Generated(hash = 894456595)
    private transient AccountBeanDao myDao;


    @Generated(hash = 2142287315)
    public AccountBean(Long id, @NotNull String userId, String nickName,
                       String avatarUrl, String phoneNum, String loginPwd, String imId,
                       String imPwd) {
        this.id = id;
        this.userId = userId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.phoneNum = phoneNum;
        this.loginPwd = loginPwd;
        this.imId = imId;
        this.imPwd = imPwd;
    }


    @Generated(hash = 1267506976)
    public AccountBean() {
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


    public String getPhoneNum() {
        return this.phoneNum;
    }


    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    public String getLoginPwd() {
        return this.loginPwd;
    }


    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public String getImId() {
        return this.imId;
    }


    public void setImId(String imId) {
        this.imId = imId;
    }


    public String getImPwd() {
        return this.imPwd;
    }


    public void setImPwd(String imPwd) {
        this.imPwd = imPwd;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 23367010)
    public List<ProjectBean> getProjectList() {
        if (projectList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProjectBeanDao targetDao = daoSession.getProjectBeanDao();
            List<ProjectBean> projectListNew = targetDao._queryAccountBean_ProjectList(userId);
            synchronized (this) {
                if (projectList == null) {
                    projectList = projectListNew;
                }
            }
        }
        return projectList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 162320702)
    public synchronized void resetProjectList() {
        projectList = null;
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 185589769)
    public List<MessageBean> getMessageList() {
        if (messageList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MessageBeanDao targetDao = daoSession.getMessageBeanDao();
            List<MessageBean> messageListNew = targetDao._queryAccountBean_MessageList(userId);
            synchronized (this) {
                if (messageList == null) {
                    messageList = messageListNew;
                }
            }
        }
        return messageList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1946287196)
    public synchronized void resetMessageList() {
        messageList = null;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1379319903)
    public List<DraftMsgRecordBean> getDraftMsgRecordList() {
        if (draftMsgRecordList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DraftMsgRecordBeanDao targetDao = daoSession.getDraftMsgRecordBeanDao();
            List<DraftMsgRecordBean> draftMsgRecordListNew = targetDao
                    ._queryAccountBean_DraftMsgRecordList(userId);
            synchronized (this) {
                if (draftMsgRecordList == null) {
                    draftMsgRecordList = draftMsgRecordListNew;
                }
            }
        }
        return draftMsgRecordList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1412353418)
    public synchronized void resetDraftMsgRecordList() {
        draftMsgRecordList = null;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 566630511)
    public List<FileMsgRecordBean> getFileMsgRecordList() {
        if (fileMsgRecordList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FileMsgRecordBeanDao targetDao = daoSession.getFileMsgRecordBeanDao();
            List<FileMsgRecordBean> fileMsgRecordListNew = targetDao
                    ._queryAccountBean_FileMsgRecordList(userId);
            synchronized (this) {
                if (fileMsgRecordList == null) {
                    fileMsgRecordList = fileMsgRecordListNew;
                }
            }
        }
        return fileMsgRecordList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 539582668)
    public synchronized void resetFileMsgRecordList() {
        fileMsgRecordList = null;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1266788372)
    public List<CompanyBean> getCompanyList() {
        if (companyList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CompanyBeanDao targetDao = daoSession.getCompanyBeanDao();
            List<CompanyBean> companyListNew = targetDao._queryAccountBean_CompanyList(userId);
            synchronized (this) {
                if (companyList == null) {
                    companyList = companyListNew;
                }
            }
        }
        return companyList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1637942205)
    public synchronized void resetCompanyList() {
        companyList = null;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 810919615)
    public List<UserBean> getUserList() {
        if (userList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserBeanDao targetDao = daoSession.getUserBeanDao();
            List<UserBean> userListNew = targetDao._queryAccountBean_UserList(userId);
            synchronized (this) {
                if (userList == null) {
                    userList = userListNew;
                }
            }
        }
        return userList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1517531020)
    public synchronized void resetUserList() {
        userList = null;
    }


    public synchronized void resetHaoYouList() {
        haoYouList = null;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 851289874)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAccountBeanDao() : null;
    }

}
