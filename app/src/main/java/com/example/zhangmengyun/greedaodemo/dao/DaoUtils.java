package com.example.zhangmengyun.greedaodemo.dao;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.zhangmengyun.greedaodemo.APP;
import com.example.zhangmengyun.greedaodemo.TestUtlis;

import junit.framework.Test;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class DaoUtils {

    /**
     * 取得DaoSession
     *
     * @return
     */
    public static DaoSession getDaoSession() {

        return APP.getInstances().getDaoSession();
    }


    /**
     * 获取所有账户
     *
     * @return
     */
    public static List<AccountBean> getAllAccount() {
        return getDaoSession().getAccountBeanDao().queryBuilder().list();

    }


    /**
     * 保存登录账户
     *
     * @return true= 成功 false = 失败
     */
    public static boolean saveAccount(AccountBean bean) {

        try {
            getDaoSession().getAccountBeanDao().insertOrReplace(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 获取一个账户信息, 通过手机号码
     *
     * @param phoneNum
     * @return
     */
    public static AccountBean getAccountByPhoneNum(String phoneNum) {
        try {
            return getDaoSession().getAccountBeanDao().queryBuilder().where(AccountBeanDao.Properties.PhoneNum.eq(phoneNum)).unique();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取一个账户信息, 通过userId
     *
     * @param userId
     * @return
     */
    public static AccountBean getAccountByUserId(String userId) {

        try {
            return getDaoSession().getAccountBeanDao().queryBuilder().where(AccountBeanDao.Properties.UserId.eq(userId)).unique();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取当前登录的账户
     *
     * @return
     */
    public static AccountBean getCurrentAccount() {
        return getAccountByUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
    }


    /**
     * 添加一条消息
     *
     * @param bean
     * @return
     */
    public static boolean addMessage(MessageBean bean) {
        try {
            getDaoSession().getMessageBeanDao().insertOrReplace(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 移除一条消息
     *
     * @param bean
     * @return
     */
    public static boolean removeMessage(MessageBean bean) {
        try {
            getDaoSession().getMessageBeanDao().delete(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除全部消息
     *
     * @param
     * @return
     */
    public static boolean removeMessage(List<MessageBean> list) {
        try {
            getDaoSession().getMessageBeanDao().deleteInTx(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 移除全部用户
     *
     * @param
     * @return
     */
    public static boolean removeUser(List<UserBean> list) {
        try {
            getDaoSession().getUserBeanDao().deleteInTx(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除一条用户
     *
     * @param bean
     * @return
     */
    public static boolean removeUser(UserBean bean) {
        try {
            getDaoSession().getUserBeanDao().delete(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除所有表
     */
    public static boolean deleteData() {
        try {
            DaoMaster daoMaster = new DaoMaster(APP.getInstances().getDb());
            DaoMaster.dropAllTables(daoMaster.getDatabase(), true);
            DaoMaster.createAllTables(daoMaster.getDatabase(), true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除全部项目
     *
     * @param
     * @return
     */
    public static boolean removeProject(List<ProjectBean> list) {
        try {
            //先移除成员, 房间
            for (int x = 0; x < list.size(); x++) {
                ProjectBean bean = list.get(x);
                for (int i = 0; i < bean.getRoomList().size(); i++) {
                    RoomBean roomBean = bean.getRoomList().get(i);
                    try {
                        getDaoSession().getMemberBeanDao().deleteInTx(roomBean.getMemberList());
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                    try {
                        getDaoSession().getRoomBeanDao().deleteInTx(roomBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }

                try {
                    getDaoSession().getProjectBeanDao().deleteInTx(bean);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除一条项目
     *
     * @param bean
     * @return
     */
    public static boolean removeProject(ProjectBean bean) {
        try {
            //先移除成员, 房间
            for (int i = 0; i < bean.getRoomList().size(); i++) {
                RoomBean roomBean = bean.getRoomList().get(i);
                try {
                    getDaoSession().getMemberBeanDao().deleteInTx(roomBean.getMemberList());
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                try {
                    getDaoSession().getRoomBeanDao().deleteInTx(roomBean);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            getDaoSession().getProjectBeanDao().deleteInTx(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 移除全部文件消息
     *
     * @param
     * @return
     */
    public static boolean removeFileMsg(List<FileMsgRecordBean> list) {
        try {
            getDaoSession().getFileMsgRecordBeanDao().deleteInTx(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除一条文件消息
     *
     * @param bean
     * @return
     */
    public static boolean removeFileMsg(FileMsgRecordBean bean) {
        try {
            getDaoSession().getFileMsgRecordBeanDao().delete(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加一条用户信息
     *
     * @param bean
     * @return
     */
    public static boolean addUser(UserBean bean) {
        try {
            getDaoSession().getUserBeanDao().insertOrReplace(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 添加一个项目
     *
     * @param projectBean
     * @return
     */
    public static boolean addProject(ProjectBean projectBean) {

        try {
            getDaoSession().getProjectBeanDao().insertOrReplace(projectBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 创建文件
     *
     * @param msgRecordBean
     * @return
     */
    public static boolean addFileMsg(FileMsgRecordBean msgRecordBean) {
        try {
            getDaoSession().getFileMsgRecordBeanDao().insertOrReplace(msgRecordBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 移除全部角标消息
     *
     * @param data
     * @return
     */
    public static boolean removeDraftMsg(List<DraftMsgRecordBean> data) {
        try {
            getDaoSession().getDraftMsgRecordBeanDao().deleteInTx(data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除一个草稿消息
     *
     * @param data
     * @return
     */
    public static boolean removeDraftMsg(DraftMsgRecordBean data) {
        try {
            getDaoSession().getDraftMsgRecordBeanDao().delete(data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 添加草稿消息
     *
     * @param draftMsgRecordBean
     * @return
     */
    public static boolean addDraftMsg(DraftMsgRecordBean draftMsgRecordBean) {
        try {
            getDaoSession().getDraftMsgRecordBeanDao().insertOrReplace(draftMsgRecordBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 移除公司
     *
     * @param data
     * @return
     */
    public static boolean removeCompany(List<CompanyBean> data) {

        try {
            getDaoSession().getCompanyBeanDao().deleteInTx(data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除公司
     *
     * @param data
     * @return
     */
    public static boolean removeCompany(CompanyBean data) {

        try {
            getDaoSession().getCompanyBeanDao().deleteInTx(data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加进入公司
     *
     * @param companyBean
     * @return
     */

    public static boolean addCompany(CompanyBean companyBean) {
        try {
            getDaoSession().getCompanyBeanDao().insertOrReplace(companyBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 为项目添加房间
     *
     * @param roomBeanList
     */
    public static boolean addRoom(List<RoomBean> roomBeanList) {

        try {
            getDaoSession().getRoomBeanDao().insertOrReplaceInTx(roomBeanList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加成员到数据
     *
     * @param memberBeanList
     * @return
     */
    public static boolean addMember(List<MemberBean> memberBeanList) {
        try {
            getDaoSession().getMemberBeanDao().insertOrReplaceInTx(memberBeanList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<MemberBean> getAllMemeber() {
        List<MemberBean> allMemeber = getDaoSession().getMemberBeanDao().queryBuilder().where(MemberBeanDao.Properties.AccountUserId.eq(SPUtils.getInstance().getString(TestUtlis.last_login_id))).list();
        return allMemeber;
    }


    public static List<RoomBean> getAllRoom() {
        List<RoomBean> allRoom = getDaoSession().getRoomBeanDao().queryBuilder().where(RoomBeanDao.Properties.UserId.eq(SPUtils.getInstance().getString(TestUtlis.last_login_id))).list();
        return allRoom;
    }


    public static List<ProjectBean> getAllProject() {
        List<ProjectBean> allProject = getDaoSession().getProjectBeanDao().queryBuilder().where(ProjectBeanDao.Properties.UserId.eq(SPUtils.getInstance().getString(TestUtlis.last_login_id))).list();
        return allProject;
    }


}
