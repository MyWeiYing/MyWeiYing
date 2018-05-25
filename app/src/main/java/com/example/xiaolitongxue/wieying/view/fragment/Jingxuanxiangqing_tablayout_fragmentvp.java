package com.example.xiaolitongxue.wieying.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eric.android.view.ExpandableTextView;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.model.bean.VideoPinglunBean;
import com.example.xiaolitongxue.wieying.presenter.FindPinglunPresenter;
import com.example.xiaolitongxue.wieying.presenter.SpecialPresenter;
import com.example.xiaolitongxue.wieying.view.adapter.JianJieAdapter;
import com.example.xiaolitongxue.wieying.view.adapter.PinglunAdapter;
import com.example.xiaolitongxue.wieying.view.interfaces.IFindPinglunView;
import com.example.xiaolitongxue.wieying.view.interfaces.SpecialIView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Jingxuanxiangqing_tablayout_fragmentvp extends BaseFragment<SpecialPresenter> implements SpecialIView, IFindPinglunView {
    @BindView(R.id.texts)
    ExpandableTextView texts;
    Unbinder unbinder;
    private boolean flag;
    private RelativeLayout animoOpentext;
    private TextView animoButton;
    private SpecialPresenter presenter;
    private RecyclerView jingxuanxiangqingRecycleview;
    private RecyclerView jingxuanxiangqingRecycleviewpinglun;
    private FindPinglunPresenter findPinglunPresenter;

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_tablayout_fragmentvp, container, false);
        return view;
    }

    @Override
    protected void findViewByIdView(View view) {
        animoOpentext = view.findViewById(R.id.animoOpentext);
        jingxuanxiangqingRecycleview = view.findViewById(R.id.JingxuanxiangqingRecycleview);
        jingxuanxiangqingRecycleviewpinglun = view.findViewById(R.id.JingxuanxiangqingRecycleviewpinglun);
    }


    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        findPinglunPresenter = new FindPinglunPresenter(this);

        Bundle arguments = getArguments();
        String data = arguments.getString("data");
        String description = arguments.getString("description");

        Log.d("============", "" + arguments);
        if (data.equals("简介")) {
            if(description!=null){
                texts.setText(description);
            }

            if(texts.getText().toString().equals("收起")){
                texts.setText("展开");
            }

            //加载网络数据
            presenter = getPresenter();
            Map<String, String> map = new HashMap<>();
            map.put("catalogId", "402834815584e463015584e539330016");
            map.put("pnum", "7");
            presenter.loadDataFragmentServer(map);


        }

        if (data.equals("评论")) {
//            FindPinglunPresenter findPinglunPresenter = new FindPinglunPresenter();
//            findPinglunPresenter.VideoFindPinglun("CMCC_00000000000000001_621653189");
            animoOpentext.setVisibility(View.GONE);
            findPinglunPresenter.getFindViewPinglun("CMCC_00000000000000001_621653189");

        }

    }


    @Override
    SpecialPresenter newPresenter() {
        return new SpecialPresenter();
    }


    @Override
    public void onSuccess(SpeciallBean speciallBean) {
        Log.d("onSuccess===", speciallBean.getMsg() + "");
        JianJieAdapter adapter = new JianJieAdapter(speciallBean.getRet().getList(), getActivity());
        jingxuanxiangqingRecycleview.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
        jingxuanxiangqingRecycleview.setAdapter(adapter);
        jingxuanxiangqingRecycleview.setNestedScrollingEnabled(false);
    }


    @Override
    public void onSuccess(VideoPinglunBean data) {
        Log.d("VideoPinglunBean=======", data.getMsg() + "");
        //加载适配器
        PinglunAdapter pinglunAdapter = new PinglunAdapter(data.getRet().getList(), getContext());
        jingxuanxiangqingRecycleviewpinglun.setLayoutManager(new GridLayoutManager(getActivity(), LinearLayoutManager.VERTICAL));
        jingxuanxiangqingRecycleviewpinglun.setAdapter(pinglunAdapter);
    }

    @Override
    public void onError(String s) {
        Log.d("onSuccess===", s + "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
