package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.presenter.SpecialPresenter;
import com.example.xiaolitongxue.wieying.view.adapter.SpecialAdapter;
import com.example.xiaolitongxue.wieying.view.interfaces.SpecialIView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 专题
 */

public class SpecialFragment extends BaseFragment<SpecialPresenter> implements SpecialIView {

//    private SpecialPresenter presenter;
    private SpecialAdapter specialAdapter;
    private RecyclerView special_fragment_recycler;
    private SmartRefreshLayout smartref;

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_special_layout, container, false);



        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        Map<String, String> map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        map.put("pnum", "7");
//        presenter.loadDataFragmentServer(map);

        //加载  时长
        smartref.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                smartref.finishLoadmore(1500);
            }
        });
        //刷新 时长
        smartref.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smartref.finishRefresh(1500);
            }
        });



        p.loadDataFragmentServer(map);
    }

    @Override
    protected void findViewByIdView(View view) {
//        presenter = getPresenter();
        p = getPresenter();
        special_fragment_recycler = view.findViewById(R.id.special_fragment_recycler);
        smartref = view.findViewById(R.id.smart);


    }

    @Override
    SpecialPresenter newPresenter() {
        return new SpecialPresenter();
    }

    //重写成功
    @Override
    public void onSuccess(SpeciallBean speciallBean) {

        special_fragment_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        specialAdapter = new SpecialAdapter(speciallBean.getRet().getList(),getActivity());
        special_fragment_recycler.setAdapter(specialAdapter);

    }
    //重写失败
    @Override
    public void onError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
