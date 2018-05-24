package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.FindBean;
import com.example.xiaolitongxue.wieying.presenter.FindPresenter;
import com.example.xiaolitongxue.wieying.view.adapter.SwipStackAdapter;
import com.example.xiaolitongxue.wieying.view.interfaces.FindIView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import link.fls.swipestack.SwipeStack;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 发现
 */

public class FindFragment extends BaseFragment<FindPresenter> implements FindIView {

    private Button btn;
    private SwipeStack stack;
    private int pnum = 0;
    private SwipStackAdapter swipStackAdapter;
    private Map<String, String> map = new HashMap<>();
    private List<FindBean.RetBean.ListBean> list = new ArrayList<>();

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_find_layout, container, false);

        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {
//        catalogId=402834815584e463015584e539330016&pnum=7
        init();

    }

    private void init() {
        swipStackAdapter = new SwipStackAdapter(list, getContext());
        stack.setAdapter(swipStackAdapter);
        initListener();

        loadMore();
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                swipStackAdapter.notifyDataSetChanged();
                loadMore();
            }
        });

    }

    private void loadMore() {
        pnum++;
        list.clear();
        map.clear();
        map.put("catalogId", "402834815584e463015584e539330016");
        map.put("pnum", pnum + "");
        getPresenter().loadDataFromServer(map);
    }

    @Override
    protected void findViewByIdView(View view) {
        btn = view.findViewById(R.id.find_btn);
        stack = view.findViewById(R.id.find_swip_stack);
    }

    @Override
    FindPresenter newPresenter() {
        return new FindPresenter();
    }


    @Override
    public void onSuccess(FindBean findBean) {
        list.addAll(findBean.getRet().getList());
        swipStackAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String s) {
        Log.d("FindFragment", s);
    }
}
