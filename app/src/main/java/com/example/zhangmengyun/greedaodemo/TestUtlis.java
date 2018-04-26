package com.example.zhangmengyun.greedaodemo;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.CompanyBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;
import com.example.zhangmengyun.greedaodemo.dao.DraftMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.FileMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.MemberBean;
import com.example.zhangmengyun.greedaodemo.dao.MessageBean;
import com.example.zhangmengyun.greedaodemo.dao.ProjectBean;
import com.example.zhangmengyun.greedaodemo.dao.RoomBean;
import com.example.zhangmengyun.greedaodemo.dao.UserBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class TestUtlis {


    public static final String last_login_id = "last_login_userid";

    //根据手机 密码 创建获取一个账户信息
    public static AccountBean createAccountInfo(String phoneNum, String pwd) {

        //先通过手机号去数据查询一下是否存在

        AccountBean accountBean = DaoUtils.getAccountByPhoneNum(phoneNum);
        if (null != accountBean) {

            return accountBean;
        }

        accountBean = new AccountBean();
        accountBean.setPhoneNum(phoneNum);
        accountBean.setLoginPwd(pwd);
        accountBean.setAvatarUrl("111");
        accountBean.setUserId(phoneNum);
        accountBean.setNickName(phoneNum);
        accountBean.setImId("111");
        accountBean.setImPwd("222");

        return accountBean;
//        AccountBean bean = new AccountBean();

    }

    public static View getEmptyView(Context context) {
        TextView textView = new TextView(context);
        textView.setText("暂无数据");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public static MessageBean createMessage() {
        MessageBean bean = new MessageBean();
        bean.setMsgId(String.valueOf(TimeUtils.getNowMills()));
        bean.setAvatarUrl("1.png");
        bean.setContent("消息内容" + TimeUtils.getNowMills());
        bean.setUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setTitle("标题");
        return bean;

    }

    /**
     * 创建一个用户
     *
     * @return
     */
    public static UserBean createUser(boolean isFriend) {
        UserBean bean = new UserBean();

        bean.setUserId(String.valueOf(TimeUtils.getNowMills()));
        bean.setAvatarUrl("2.png");
        bean.setNickName("昵称" + bean.getUserId());
        bean.setAccountUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setIsFriend(isFriend);
        return bean;

    }


    /**
     * 创建一个项目
     *
     * @return
     */
    public static ProjectBean createProject() {
        ProjectBean bean = new ProjectBean();
        bean.setProjectId(String.valueOf(TimeUtils.getNowMills()));
        bean.setAvatarUrl("2.png");
        bean.setUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setName("项目" + bean.getUserId());
        bean.setMyRoomId("11");
        bean.setMyRoomImId("22");

        //创建项目的同时, 要给他创建房间
        List<RoomBean> roomBeanList = new ArrayList<>();

        Random random = new Random();
        int count = random.nextInt(5) + 2;
        for (int i = 0; i < count; i++) {
            RoomBean roomBean = new RoomBean();
            roomBean.setProjectId(bean.getProjectId());
            roomBean.setRoomId(String.valueOf(TimeUtils.getNowMills() + i));
            roomBean.setName("房间 " + i);
            roomBean.setRoomClassName("111");
            roomBean.setTagName("TAG");
            roomBean.setAvatarUrl("3.png");
            roomBean.setMemberType(1);
            roomBean.setRoomClass(12);
            roomBean.setUserId(bean.getUserId());
            roomBeanList.add(roomBean);


            List<MemberBean> memberBeanList = new ArrayList<>();

            Random random2 = new Random();
            int count2 = random2.nextInt(10) + 2;
            //创建房间的时候要创建成员
            for (int x = 0; x < count2; x++) {
                MemberBean memberBean = new MemberBean();
                memberBean.setRoomId(roomBean.getRoomId());
                memberBean.setUserId(String.valueOf(TimeUtils.getNowMills() + x));
                memberBean.setAvatarUrl("3.png");
                memberBean.setImId("222");
                memberBean.setNickName("名称" + x);
                memberBean.setTagName("测试");
                memberBean.setAccountUserId(bean.getUserId());
                memberBeanList.add(memberBean);
            }
            //添加成员到房间 数据库
            DaoUtils.addMember(memberBeanList);
        }


        DaoUtils.getAllMemeber();


        //添加房间到数据库
        DaoUtils.addRoom(roomBeanList);

        return bean;
    }


    /**
     * 创建一个文件消息
     *
     * @return
     */
    public static FileMsgRecordBean createFileMsg() {
        FileMsgRecordBean bean = new FileMsgRecordBean();

        bean.setMsgId(String.valueOf(TimeUtils.getNowMills()));
        bean.setFilePath("");
        bean.setFileName("文件名" + bean.getUserId());
        bean.setUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setImId("11");
        return bean;
    }

    /**
     * 创建草稿消息
     *
     * @return
     */
    public static DraftMsgRecordBean createCaoGaoMsg() {
        DraftMsgRecordBean bean = new DraftMsgRecordBean();

        bean.setContent(String.valueOf(TimeUtils.getNowMills()));
        bean.setTime(TimeUtils.getNowMills());
        bean.setUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setContent("文件名" + bean.getUserId());
        bean.setImId("11");
        return bean;
    }

    /**
     * 创建公司
     *
     * @return
     */
    public static CompanyBean createGongSi() {
        CompanyBean bean = new CompanyBean();
        bean.setCompanyId(String.valueOf(TimeUtils.getNowMills()));
        bean.setCompanyCode("111");
        bean.setUserId(SPUtils.getInstance().getString(TestUtlis.last_login_id));
        bean.setCompanyName("公司名" + bean.getUserId());
        return bean;
    }
}

