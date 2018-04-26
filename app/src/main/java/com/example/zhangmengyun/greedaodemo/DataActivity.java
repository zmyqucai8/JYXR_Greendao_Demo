package com.example.zhangmengyun.greedaodemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.zhangmengyun.greedaodemo.fragment.CaoGaoFragment;
import com.example.zhangmengyun.greedaodemo.fragment.GongSiFragment;
import com.example.zhangmengyun.greedaodemo.fragment.HaoYouFragment;
import com.example.zhangmengyun.greedaodemo.fragment.WenJianFragment;
import com.example.zhangmengyun.greedaodemo.fragment.XiangMuFragment;
import com.example.zhangmengyun.greedaodemo.fragment.XiaoXiFragment;
import com.example.zhangmengyun.greedaodemo.fragment.YongHuFragment;
import com.example.zhangmengyun.greedaodemo.fragment.ZhangHuFragment;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class DataActivity extends AppCompatActivity {

    public static void start(Context context, String name) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra("name", name);
        context.startActivity(intent);
    }


    public static void start(Context context, String name,String key) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("key", key);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_activity);

        String name = getIntent().getStringExtra("name");
        Fragment fragment = null;
        switch (name) {
            case "zhanghu":
                fragment = new ZhangHuFragment();
                break;
            case "xiaoxi":
                fragment = new XiaoXiFragment();
                break;

            case "yonghu":
                fragment = new YongHuFragment();
                break;

            case "haoyou":
                fragment = new HaoYouFragment();
                break;

            case "xiangmu":
                fragment = new XiangMuFragment();
                break;

            case "gongsi":
                fragment = new GongSiFragment();
                break;

            case "wenjian":
                fragment = new WenJianFragment();
                break;
            case "caogao":
                fragment = new CaoGaoFragment();
                break;

        }

        if (null == fragment) {
            ToastUtils.showShort("参数错误");
            finish();
            return;
        }
        FragmentUtils.add(getSupportFragmentManager(), fragment, R.id.fragment, false);
    }
}
