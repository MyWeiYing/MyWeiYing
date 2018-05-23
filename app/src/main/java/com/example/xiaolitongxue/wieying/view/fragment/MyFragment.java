package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.MyBean;
import com.example.xiaolitongxue.wieying.presenter.MyPresenter;
import com.example.xiaolitongxue.wieying.view.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 我的
 */

public class MyFragment extends BaseFragment<MyPresenter> {

    private RecyclerView myRecycler;
    private int[] imgs = new int[]{R.mipmap.my_records, R.mipmap.my_down, R.mipmap.my_collection, R.mipmap.my_everyone};
    private String[] titles = new String[]{"历史", "缓存", "收藏", "主题"};

    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_my_layout, container, false);
        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        List<MyBean> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            MyBean myBean = new MyBean();
            myBean.setImg(imgs[i]);
            myBean.setTitle(titles[i]);
            list.add(myBean);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        myRecycler.setLayoutManager(manager);
        myRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        myRecycler.setAdapter(new MyRecyclerAdapter(list, getContext()));

    }

    @Override
    void findViewByIdView(View view) {
        myRecycler = view.findViewById(R.id.my_recycler);
    }

    @Override
    MyPresenter newPresenter() {
        return new MyPresenter();
    }
}
