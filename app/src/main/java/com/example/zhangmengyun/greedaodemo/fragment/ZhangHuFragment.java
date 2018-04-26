package com.example.zhangmengyun.greedaodemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhangmengyun.greedaodemo.R;
import com.example.zhangmengyun.greedaodemo.TestUtlis;
import com.example.zhangmengyun.greedaodemo.adapter.ZhangHuAdapter;
import com.example.zhangmengyun.greedaodemo.dao.AccountBean;
import com.example.zhangmengyun.greedaodemo.dao.DaoUtils;

import junit.framework.Test;

import java.util.List;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class ZhangHuFragment extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.zhanghu_fragment, null);

        recyclerView = view.findViewById(R.id.recyclerView);

        initData();
        return view;
    }

    public void initData(){
        //获取账户数据
        List<AccountBean> allAccount = DaoUtils.getAllAccount();
        ZhangHuAdapter adapter = new ZhangHuAdapter(this, allAccount);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setEmptyView(TestUtlis.getEmptyView(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}

