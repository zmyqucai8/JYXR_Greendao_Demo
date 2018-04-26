package com.example.zhangmengyun.greedaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        String last_login_userid = SPUtils.getInstance().getString(TestUtlis.last_login_id);
        if (!TextUtils.isEmpty(last_login_userid)) {

            AccountBean accountByUserId = DaoUtils.getAccountByUserId(last_login_userid);

            if (null != accountByUserId) {
                //已经有登录的用户, 去登录进入主页
                toMainPage();
            } else {
                toLoginPage();
            }
        } else {
            toLoginPage();
        }


    }


    public void toMainPage() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //最后登录的id 数据为空, 去登录页面
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 1500);
    }

    public void toLoginPage() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //最后登录的id 数据为空, 去登录页面
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 1500);
    }
}
