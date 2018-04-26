package com.example.zhangmengyun.greedaodemo.adapter;

import android.support.v4.app.Fragment;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.dao.DraftMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.FileMsgRecordBean;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class CaoGaoAdapter extends BaseQuickAdapter<DraftMsgRecordBean, BaseViewHolder> {
    //    private XiaoXiFragment mFragment;
    String last_login_id;

    public CaoGaoAdapter(Fragment fragment, List<DraftMsgRecordBean> data) {
        super(R.layout.item_zhanghu, data);

//        this.mFragment = fragment;


//        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DraftMsgRecordBean item) {

        helper.setText(R.id.tv_data, item.toString());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(item.getContent());
            }
        });
    }
}
