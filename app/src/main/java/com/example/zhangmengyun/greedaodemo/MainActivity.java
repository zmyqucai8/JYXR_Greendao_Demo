package com.example.zhangmengyun.greedaodemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv_zhanghu;


    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        tv_zhanghu = (TextView) findViewById(R.id.tv_zhanghu);
        initData();
    }

    public void initData() {
        String last_login_userid = SPUtils.getInstance().getString(TestUtlis.last_login_id);
        AccountBean accountBean = DaoUtils.getAccountByUserId(last_login_userid);
        tv_zhanghu.setText("账户\n当前登录用户:" + accountBean.getNickName());

    }








    public void zhanghu(View view) {
        DataActivity.start(this, "zhanghu");
    }

    public void caogao(View view) {

        DataActivity.start(this, "caogao");
    }

    public void wenjian(View view) {
        DataActivity.start(this, "wenjian");
    }

    public void gongsi(View view) {
        DataActivity.start(this, "gongsi");
    }

    public void xiangmu(View view) {
        DataActivity.start(this, "xiangmu");
    }

    public void haoyou(View view) {
        DataActivity.start(this, "haoyou");
    }

    public void yonghu(View view) {
        DataActivity.start(this, "yonghu");
    }

    public void xiaoxi(View view) {
        DataActivity.start(this, "xiaoxi");
    }


    public void tuichu(View view) {
//        SPUtils.getInstance().put(TestUtlis.last_login_id, "");
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
