package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaolitongxue.wieying.presenter.BasePresenter;
import com.example.xiaolitongxue.wieying.view.interfaces.BaseIView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseIView{
    private P p;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater,container);
        unbinder = ButterKnife.bind(this, view);
        p = newPresenter();
        p.attachView(this);
        findViewByIdView(view);
        initData(savedInstanceState);
        return view;
    }

    abstract View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);
    abstract void initData( @Nullable Bundle savedInstanceState);
    abstract void findViewByIdView(View view);
    abstract P newPresenter();
    public P getPresenter(){
        return p;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        p.detachView();
        unbinder.unbind();
    }
}
