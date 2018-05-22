package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.MyBean;
import com.example.xiaolitongxue.wieying.presenter.MyPresenter;
import com.example.xiaolitongxue.wieying.view.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 我的
 */

public class MyFragment extends BaseFragment<MyPresenter>{

    @BindView(R.id.my_set)
    ImageView mySet;
    @BindView(R.id.my_recycler)
    RecyclerView myRecycler;
    Unbinder unbinder;

    private int[] imgs = new int[]{R.mipmap.my_records,R.mipmap.my_down,R.mipmap.my_collection,R.mipmap.my_everyone};
    private String[] titles = new String[]{"历史","缓存","收藏","主题"};

    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_my_layout,container,false);
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
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        myRecycler.setLayoutManager(manager);
        myRecycler.setAdapter(new MyRecyclerAdapter(list,getContext()));
    }

    @Override
    void findViewByIdView(View view) {

    }

    @Override
    MyPresenter newPresenter() {
        return new MyPresenter();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
