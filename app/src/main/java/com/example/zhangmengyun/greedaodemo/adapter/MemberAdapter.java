package com.example.zhangmengyun.greedaodemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.ProjectRoomPop;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.dao.MemberBean;
import com.example.zhangmengyun.greedaodemo.dao.RoomBean;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class MemberAdapter extends BaseQuickAdapter<MemberBean, BaseViewHolder> {
    //    private XiaoXiFragment mFragment;
    String last_login_id;

    public MemberAdapter(Context context, List<MemberBean> data) {
        super(R.layout.item_zhanghu, data);

//        this.mFragment = fragment;
        this.mContext = context;

//        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MemberBean item) {

        helper.setText(R.id.tv_data, item.toString());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(item.getNickName());

            }
        });
    }
}
