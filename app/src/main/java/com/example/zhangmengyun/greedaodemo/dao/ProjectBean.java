package com.example.zhangmengyun.greedaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by zhangmengyun on 2018/4/25.
 * <p>
 * 我的项目表
 */
@Entity
public class ProjectBean {

    @Override
    public String toString() {
        return "ProjectBean{" +
                "id=" + id +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", myRoomId='" + myRoomId + '\'' +
                ", myRoomImId='" + myRoomImId + '\'' +
                ", userId='" + userId + '\'' +
                ", roomList=" + roomList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }

    @Id
    private Long id;
    @Index(unique = true)
    private String projectId;
    private String name;
    private String avatarUrl;
    private String myRoomId;
    private String myRoomImId;

    private String userId;


    //项目下房间列表
    @ToMany(joinProperties = {@JoinProperty(name = "projectId", referencedName = "projectId")
    })
//    @OrderBy("date ASC")
    private List<RoomBean> roomList;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1016787166)
    private transient ProjectBeanDao myDao;


    @Generated(hash = 985310363)
    public ProjectBean(Long id, String projectId, String name, String avatarUrl,
                       String myRoomId, String myRoomImId, String userId) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.myRoomId = myRoomId;
        this.myRoomImId = myRoomImId;
        this.userId = userId;
    }


    @Generated(hash = 882656566)
    public ProjectBean() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getProjectId() {
        return this.projectId;
    }


    public void setProjectId(String projectId) {
        this.projectId = projectId;
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


    public String getMyRoomId() {
        return this.myRoomId;
    }


    public void setMyRoomId(String myRoomId) {
        this.myRoomId = myRoomId;
    }


    public String getMyRoomImId() {
        return this.myRoomImId;
    }


    public void setMyRoomImId(String myRoomImId) {
        this.myRoomImId = myRoomImId;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1837979036)
    public List<RoomBean> getRoomList() {
        if (roomList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RoomBeanDao targetDao = daoSession.getRoomBeanDao();
            List<RoomBean> roomListNew = targetDao._queryProjectBean_RoomList(projectId);
            synchronized (this) {
                if (roomList == null) {
                    roomList = roomListNew;
                }
            }
        }
        return roomList;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 811059884)
    public synchronized void resetRoomList() {
        roomList = null;
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


    public String getUserId() {
        return this.userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1605365882)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProjectBeanDao() : null;
    }

}
