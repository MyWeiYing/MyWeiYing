package com.example.xiaolitongxue.wieying.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.presenter.ChoicenessPresenter;
import com.example.xiaolitongxue.wieying.view.interfaces.ChoicenessIView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 精选
 */

public class ChoicenessFragment extends BaseFragment<ChoicenessPresenter> implements ChoicenessIView {

    private View view;
    private ChoicenessPresenter presenter;
    private static final String TAG = "ChoicenessFragment";

    //创建并返回数据
    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {

        view = inflater.inflate(R.layout.fragment_choiceness_layout, container, false);
        return view;
    }

    @Override
    void findViewByIdView(View view) {
        presenter = getPresenter();
        //findViewById的方法可以使用黄油刀

    }

    //创建Presenter实例
    @Override
    ChoicenessPresenter newPresenter() {
        return new ChoicenessPresenter();
    }


    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        //初始化数据

    }

    @Override
    public void onSuccess(ChoicenessBean choicenessBean) {
        //获取数据成功
        Log.d(TAG, "onSuccess: -----" + choicenessBean.getMsg());
    }

    @Override
    public void onError(String s) {
        //获取数据失败
        Log.d(TAG, "onError: ---------" + s);
    }




}
