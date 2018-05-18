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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 专题
 */

public class SpecialFragment extends BaseFragment<SpecialPresenter> implements SpecialIView {

    private SpecialPresenter presenter;
    private SpecialAdapter specialAdapter;
    private RecyclerView special_fragment_recycler;

    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_special_layout, container, false);
        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        Map<String, String> map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        map.put("pnum", "7");
        presenter.loadDataFragmentServer(map);
    }

    @Override
    void findViewByIdView(View view) {
        presenter = getPresenter();
        special_fragment_recycler = view.findViewById(R.id.special_fragment_recycler);

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
        Toast.makeText(getContext(), speciallBean.getMsg(), Toast.LENGTH_SHORT).show();

    }
    //重写失败
    @Override
    public void onError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
