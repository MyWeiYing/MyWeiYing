package com.example.xiaolitongxue.wieying.view.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class Jingxuanxiangqing_tablayout_fragmentvp extends BaseFragment<SpecialPresenter> implements SpecialIView,IFindPinglunView {
    private boolean flag;
    private RelativeLayout animoOpentext;
    private TextView texts;
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
        texts = view.findViewById(R.id.texts);
        animoOpentext = view.findViewById(R.id.animoOpentext);
        animoButton = view.findViewById(R.id.animoButton);
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
        if (data.equals("简介")){
            texts.setText(description);
            //展开收起动画点击事件
            animoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //展开收起动画
                    if (animoButton.getText().toString().equals("展开")) {
                        animooPentext();
                        animoButton.setText("收起");
                    }
                    if (animoButton.getText().equals("收起")) {
                        animoofftext();
                        animoButton.setText("展开");
                    }
                }
            });

            //加载网络数据
            presenter = getPresenter();
            Map<String,String> map = new HashMap<>();
            map.put("catalogId","402834815584e463015584e539330016");
            map.put("pnum","7");
            presenter.loadDataFragmentServer(map);


        }

        if (data.equals("评论")) {
            animoOpentext.setVisibility(View.GONE);
            texts.setVisibility(View.GONE);
//            FindPinglunPresenter findPinglunPresenter = new FindPinglunPresenter();
//            findPinglunPresenter.VideoFindPinglun("CMCC_00000000000000001_621653189");


            findPinglunPresenter.getFindViewPinglun("CMCC_00000000000000001_621653189");

        }

    }


    @Override
    SpecialPresenter newPresenter() {
        return new SpecialPresenter();
    }

    //展开向下移动
    private void animooPentext() {
        float ctranslationY = animoOpentext.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(animoOpentext, "translationY", ctranslationY, -500f);
        animator.setDuration(2000);
        animator.start();
    }

    private void animoofftext() {
        float ctranslationY = animoOpentext.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(animoOpentext, "translationY", ctranslationY, 500f);
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    public void onSuccess(SpeciallBean speciallBean) {
        Log.d("onSuccess===",speciallBean.getMsg()+"");
        JianJieAdapter adapter = new JianJieAdapter(speciallBean.getRet().getList(),getActivity());
        jingxuanxiangqingRecycleview.setLayoutManager(new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false));
        jingxuanxiangqingRecycleview.setAdapter(adapter);
        jingxuanxiangqingRecycleview.setNestedScrollingEnabled(false);
    }


    @Override
    public void onSuccess(VideoPinglunBean data) {
        Log.d("VideoPinglunBean=======",data.getMsg()+"");
        //加载适配器
        PinglunAdapter pinglunAdapter = new PinglunAdapter(data.getRet().getList(),getContext());
        jingxuanxiangqingRecycleviewpinglun.setLayoutManager(new GridLayoutManager(getActivity(), LinearLayoutManager.VERTICAL));
        jingxuanxiangqingRecycleviewpinglun.setAdapter(pinglunAdapter);
    }

    @Override
    public void onError(String s) {
        Log.d("onSuccess===",s+"");
    }

}
