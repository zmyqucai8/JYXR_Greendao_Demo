package com.example.zhangmengyun.greedaodemo;

import android.app.WallpaperInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoMaster;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;
import com.example.zhangmengyun.greedaodemo.dao.MemberBean;
import com.example.zhangmengyun.greedaodemo.dao.ProjectBean;
import com.example.zhangmengyun.greedaodemo.dao.RoomBean;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class LoginActivity extends AppCompatActivity {
    AppCompatEditText et_pwd;
    AppCompatEditText et_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        et_pwd = (AppCompatEditText) findViewById(R.id.et_pwd);
        et_phone = (AppCompatEditText) findViewById(R.id.et_phone);
    }


    public void login(View v) {
        String phone = et_phone.getText().toString();
        String pwd = et_pwd.getText().toString();

        //保存账户

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
            ToastUtils.showShort("手机号/密码不能为空");
            return;
        }
        AccountBean accountInfo = TestUtlis.createAccountInfo(phone, pwd);
        if (DaoUtils.saveAccount(accountInfo)) {
            ToastUtils.showShort("登录成功");
            SPUtils.getInstance().put("last_login_userid", phone);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            ToastUtils.showShort("登录失败");
        }


    }

    public void cleanData(View view) {
        if (DaoUtils.deleteData()) {
            ToastUtils.showShort("清除成功");

        } else {
            ToastUtils.showShort("清除失败");
        }
    }

    public void showAllMemberCount(View view) {
        List<MemberBean> allMemeber = DaoUtils.getAllMemeber();
        ToastUtils.showShort(String.valueOf(null != allMemeber ? allMemeber.size() : 0));
    }

    public void showAllRoomCount(View view) {
        List<RoomBean> allRoom = DaoUtils.getAllRoom();
        ToastUtils.showShort(String.valueOf(null != allRoom ? allRoom.size() : 0));
    }

    public void showAllProjectCount(View view) {
        List<ProjectBean> allProject = DaoUtils.getAllProject();
        ToastUtils.showShort(String.valueOf(null != allProject ? allProject.size() : 0));
    }
}
