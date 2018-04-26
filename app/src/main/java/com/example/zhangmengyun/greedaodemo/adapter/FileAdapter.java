package com.example.zhangmengyun.greedaodemo.adapter;

import android.support.v4.app.Fragment;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.dao.FileMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.ProjectBean;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/26.
 */

public class FileAdapter extends BaseQuickAdapter<FileMsgRecordBean, BaseViewHolder> {
    //    private XiaoXiFragment mFragment;
    String last_login_id;

    public FileAdapter(Fragment fragment, List<FileMsgRecordBean> data) {
        super(R.layout.item_zhanghu, data);

//        this.mFragment = fragment;


//        last_login_id = SPUtils.getInstance().getString(TestUtlis.last_login_id);
    }

    @Override
    protected void convert(BaseViewHolder helper, final FileMsgRecordBean item) {

        helper.setText(R.id.tv_data, item.toString());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(item.getFileName());
            }
        });
    }
}
