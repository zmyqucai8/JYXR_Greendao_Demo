package com.example.zhangmengyun.greedaodemo.adapter;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.MainActivity;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.TestUtlis;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.fragment.ZhangHuFragment;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class ZhangHuAdapter extends BaseQuickAdapter<AccountBean, BaseViewHolder> {
    private ZhangHuFragment mFragment;
    String last_login_id;

    public ZhangHuAdapter(ZhangHuFragment fragment, List<AccountBean> data) {
        super(R.layout.item_zhanghu, data);

        this.mFragment = fragment;


        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final AccountBean item) {

        if (last_login_id.equals(item.getUserId())) {
            helper.setText(R.id.tv_data, "当前登录账户:\n" + item.toString());
        } else {
            helper.setText(R.id.tv_data, item.toString());
        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不是当前登录的账户就需要切换账户
                if (!last_login_id.equals(item.getUserId())) {
                    SPUtils.getInstance().put(TestUtlis.last_login_id, item.getUserId());
                    mFragment.initData();
                    if(null!=MainActivity.mainActivity){
                        MainActivity.mainActivity.initData();
                    }
                }
            }
        });
    }
}
