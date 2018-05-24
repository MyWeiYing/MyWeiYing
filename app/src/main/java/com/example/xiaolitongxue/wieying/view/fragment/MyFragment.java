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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 我的
 */

public class MyFragment extends BaseFragment<MyPresenter> {


    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_my_layout, container, false);
        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {


    }

    @Override
    protected void findViewByIdView(View view) {
    }

    @Override
    MyPresenter newPresenter() {
        return new MyPresenter();
    }
}
