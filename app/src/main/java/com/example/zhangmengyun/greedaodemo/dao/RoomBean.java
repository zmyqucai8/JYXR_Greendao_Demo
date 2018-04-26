package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by zhangmengyun on 2018/4/25.
 * <p>
 * 我的房间表  - 办公室 / 会议室 / 项目群聊/ 普通群聊
 */
@Entity
public class RoomBean {

    @Id
    private Long id;
    @Index(unique = true)
    private String roomId;
    private String roomImId;
    private int roomType;
    private String name;
    private String avatarUrl;
    private String roomClassName;
    private int roomClass;
    private String companyName;
    private String tagName;

    private  String userId;
    //属于该项目id下的房间
    private String projectId;

    private int memberType;


    @Override
    public String toString() {
        return "RoomBean{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                ", roomImId='" + roomImId + '\'' +
                ", roomType=" + roomType +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", roomClassName='" + roomClassName + '\'' +
                ", roomClass=" + roomClass +
                ", companyName='" + companyName + '\'' +
                ", tagName='" + tagName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", memberType=" + memberType +
                ", memberList=" + memberList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }

    //成员列表
    @ToMany(joinProperties = {@JoinProperty(name = "roomId", referencedName = "roomId")
    })
//    @OrderBy("date ASC")
    private List<MemberBean> memberList;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1345831925)
    private transient RoomBeanDao myDao;

    @Generated(hash = 771535847)
    public RoomBean(Long id, String roomId, String roomImId, int roomType, String name,
            String avatarUrl, String roomClassName, int roomClass, String companyName,
            String tagName, String userId, String projectId, int memberType) {
        this.id = id;
        this.roomId = roomId;
        this.roomImId = roomImId;
        this.roomType = roomType;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.roomClassName = roomClassName;
        this.roomClass = roomClass;
        this.companyName = companyName;
        this.tagName = tagName;
        this.userId = userId;
        this.projectId = projectId;
        this.memberType = memberType;
    }

    @Generated(hash = 2135387174)
    public RoomBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomImId() {
        return this.roomImId;
    }

    public void setRoomImId(String roomImId) {
        this.roomImId = roomImId;
    }

    public int getRoomType() {
        return this.roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRoomClassName() {
        return this.roomClassName;
    }

    public void setRoomClassName(String roomClassName) {
        this.roomClassName = roomClassName;
    }

    public int getRoomClass() {
        return this.roomClass;
    }

    public void setRoomClass(int roomClass) {
        this.roomClass = roomClass;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1178235246)
    public List<MemberBean> getMemberList() {
        if (memberList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberBeanDao targetDao = daoSession.getMemberBeanDao();
            List<MemberBean> memberListNew = targetDao._queryRoomBean_MemberList(roomId);
            synchronized (this) {
                if (memberList == null) {
                    memberList = memberListNew;
                }
            }
        }
        return memberList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1794216443)
    public synchronized void resetMemberList() {
        memberList = null;
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

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 187241317)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRoomBeanDao() : null;
    }


}
