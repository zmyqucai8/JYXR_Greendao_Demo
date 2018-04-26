package com.example.zhangmengyun.greedaodemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.DataActivity;
import com.example.zhangmengyun.greedaodemo.ProjectRoomPop;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.dao.ProjectBean;
import com.example.zhangmengyun.greedaodemo.dao.RoomBean;
import com.example.zhangmengyun.greedaodemo.dao.UserBean;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class XiangMuAdapter extends BaseQuickAdapter<ProjectBean, BaseViewHolder> {

    public XiangMuAdapter(Fragment fragment, List<ProjectBean> data) {
        super(R.layout.item_zhanghu, data);

        this.mContext = fragment.getActivity();


//        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ProjectBean item) {

        helper.setText(R.id.tv_data, item.toString());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(item.getName());
                //进入项目 的房间列表
                List<RoomBean> roomList = item.getRoomList();


                ProjectRoomPop projectRoomPop = new ProjectRoomPop(mContext, roomList, item.getName());
//
                projectRoomPop.showAtLocation(((Activity) mContext).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//              new ProjectRoomDialog(mContext).initData(roomList,item.getName()).show();


            }
        });
    }
}
