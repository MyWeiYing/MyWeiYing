package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.presenter.SpecialPresenter;
import com.example.xiaolitongxue.wieying.view.interfaces.SpecialIView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 专题
 */

public class SpecialFragment extends BaseFragment<SpecialPresenter> implements SpecialIView {

    private SpecialPresenter presenter;

    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_special_layout, container, false);
        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        Map<String,String> map = new HashMap<>();
//        catalogId=402834815584e463015584e539330016&pnum=7
        map.put("catalogId","402834815584e463015584e539330016");
        map.put("pnum","7");
        presenter.loadDataFragmentServer(map);
    }

    @Override
    void findViewByIdView(View view) {
        presenter = getPresenter();

    }

    @Override
    SpecialPresenter newPresenter() {
        return new SpecialPresenter();
    }


    //重写成功
    @Override
    public void onSuccess(SpeciallBean speciallBean) {
        Toast.makeText(getContext(), speciallBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    //重写失败
    @Override
    public void onError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
