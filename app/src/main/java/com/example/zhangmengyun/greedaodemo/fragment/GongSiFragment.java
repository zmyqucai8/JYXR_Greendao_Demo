package com.example.zhangmengyun.greedaodemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.TestUtlis;
import com.example.zhangmengyun.greedaodemo.adapter.CaoGaoAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.FileAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.GongSiAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.XiangMuAdapter;
import com.example.zhangmengyun.greedaodemo.adapter.YongHuAdapter;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.CompanyBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;
import com.example.zhangmengyun.greedaodemo.dao.DraftMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.FileMsgRecordBean;
import com.example.zhangmengyun.greedaodemo.dao.ProjectBean;
import com.example.zhangmengyun.greedaodemo.dao.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class GongSiFragment extends Fragment implements View.OnClickListener {
    Button btn_remove_all;
    Button btn_remove_last;
    Button btn_add;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xiaoxi_fragment, null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        btn_remove_all = view.findViewById(R.id.btn_remove_all);
        TextView tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText("公司");
        btn_remove_last = view.findViewById(R.id.btn_remove_last);
        btn_add = view.findViewById(R.id.btn_add);
        recyclerView = view.findViewById(R.id.recyclerView);
        btn_add.setOnClickListener(this);
        btn_remove_last.setOnClickListener(this);
        btn_remove_all.setOnClickListener(this);
    }

    List<CompanyBean> companyList;
    GongSiAdapter adapter;

    public void initData() {
        //获取当前账户消息数据
        AccountBean currentAccount = DaoUtils.getCurrentAccount();
        companyList = currentAccount.getCompanyList();
        if (null == companyList) {
            companyList = new ArrayList<>();
        }
        adapter = new GongSiAdapter(this, companyList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.setEmptyView(TestUtlis.getEmptyView(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_remove_all:
                //移除全部
                if (adapter.getData().size() > 0 && DaoUtils.removeCompany(adapter.getData())) {
                    ToastUtils.showShort("移除成功");
                    adapter.getData().clear();
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.showShort("移除失败");
                }

                break;
            case R.id.btn_remove_last:
                //移除最后一条
                if (adapter.getData().size() > 0 && DaoUtils.removeCompany(adapter.getData().get(adapter.getData().size() - 1))) {
                    ToastUtils.showShort("移除成功");
                    adapter.remove(adapter.getData().size() - 1);
                } else {
                    ToastUtils.showShort("移除失败");
                }
                break;
            case R.id.btn_add:
                //添加一条
                CompanyBean companyBean = TestUtlis.createGongSi();
                if (DaoUtils.addCompany(companyBean)) {
                    adapter.addData(companyBean);
                    recyclerView.scrollToPosition(adapter.getItemCount()-1);
                    ToastUtils.showShort("添加成功");
                } else ToastUtils.showShort("添加失败");
                break;
        }
    }
}
