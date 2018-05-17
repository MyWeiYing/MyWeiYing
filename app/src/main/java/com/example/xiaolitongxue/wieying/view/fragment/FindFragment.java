package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.presenter.ChoicenessPresenter;
import com.example.xiaolitongxue.wieying.presenter.FindPresenter;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 发现
 */

public class FindFragment extends BaseFragment<FindPresenter>{
    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_find_layout,container,false);
        return view;
    }

    @Override
    void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    void findViewByIdView(View view) {

    }

    @Override
    FindPresenter newPresenter() {
        return new FindPresenter();
    }


}
