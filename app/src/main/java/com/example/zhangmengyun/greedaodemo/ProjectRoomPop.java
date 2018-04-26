package com.example.zhangmengyun.greedaodemo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.CaoGaoAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.RoomAdapter;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;
import com.example.zhangmengyun.greedaodemo.dao.DraftMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.RoomBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class ProjectRoomPop extends PopupWindow{



    RecyclerView recyclerView;
String projectName;
    Context context;

    public ProjectRoomPop(@NonNull final Context context,List<RoomBean> list,String projectName) {
        super(context);
        this.context = context;
        this.projectName = projectName;

        View view = View.inflate(context, R.layout.pop_project_room, null);
        initView(view);
        setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(false);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(android.R.style.Animation_Dialog);

        initData(list);

    }

    RoomAdapter adapter;



    public void initData(List<RoomBean> list) {
        //获取当前账户消息数据
//        AccountBean currentAccount = DaoUtils.getCurrentAccount();
//        draftMsgRecordList = currentAccount.getDraftMsgRecordList();
//        if (null == draftMsgRecordList) {
//            draftMsgRecordList = new ArrayList<>();
//        }
        adapter = new RoomAdapter(context, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.setEmptyView(TestUtlis.getEmptyView(context));
        recyclerView.setAdapter(adapter);

    }


    private void initView(View view) {
        TextView tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText(projectName);
        recyclerView = view.findViewById(R.id.recyclerView);
    }



}
