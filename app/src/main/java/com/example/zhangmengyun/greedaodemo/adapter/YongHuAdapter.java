package com.example.zhangmengyun.greedaodemo.adapter;

import android.support.v4.app.Fragment;
import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.TestUtlis;
import com.example.zhangmengyun.greedaodemo.dao.MessageBean;
import com.example.zhangmengyun.greedaodemo.dao.UserBean;
import com.example.zhangmengyun.greedaodemo.fragment.XiaoXiFragment;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class YongHuAdapter extends BaseQuickAdapter<UserBean, BaseViewHolder> {
//    private XiaoXiFragment mFragment;
    String last_login_id;

    public YongHuAdapter(Fragment fragment, List<UserBean> data) {
        super(R.layout.item_zhanghu, data);

//        this.mFragment = fragment;


//        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final UserBean item) {

        helper.setText(R.id.tv_data, item.toString());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(item.getNickName());
            }
        });
    }
}
