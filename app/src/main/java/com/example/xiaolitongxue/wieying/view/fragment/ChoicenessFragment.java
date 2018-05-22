package com.example.xiaolitongxue.wieying.view.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.myBanner.MyBanner;
import com.example.xiaolitongxue.wieying.presenter.ChoicenessPresenter;
import com.example.xiaolitongxue.wieying.view.MainActivity;
import com.example.xiaolitongxue.wieying.view.adapter.JIngxuanAdapter;

import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;
import com.example.xiaolitongxue.wieying.view.custom.ObserveScrollView;
import com.example.xiaolitongxue.wieying.view.interfaces.ChoicenessIView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 精选
 */

public class ChoicenessFragment extends BaseFragment<ChoicenessPresenter> implements ChoicenessIView {
    private View view;
    private ChoicenessPresenter presenter;
    private static final String TAG = "ChoicenessFragment";
    private Banner mbanner;
    private RecyclerView mlistview;
    private RelativeLayout relatadrawcolor;
    private ChoicenessBean choicenessBean;
    private List<String> listimgs = new ArrayList<>();
    private String img1 = "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/20/1500546405463031004.jpg";
    private String img2 = "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/08/03/1501747440798060882.jpg";
    private String img3 = "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/08/03/1501747440798060882.jpg";
    private String img4 = "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/06/20/1497939658612079464.jpg";
    private String img5 = "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/06/20/1497940129455060640.jpg";
    private ObserveScrollView mScrollview;
    private MyTitleBar titlebar;

    //创建并返回数据
    @Override
    View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_choiceness_layout, container, false);
        return view;
    }



    @Override
    void findViewByIdView(View view) {
        mbanner = view.findViewById(R.id.mbanner);
        mlistview = view.findViewById(R.id.mlistview);
        relatadrawcolor = view.findViewById(R.id.Relatadrawcolor);
        mScrollview = view.findViewById(R.id.mScrollview);
        titlebar = view.findViewById(R.id.choiceness_titlebar);
        presenter = getPresenter();
        //findViewById的方法可以使用黄油刀

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    void initData(@Nullable Bundle savedInstanceState) {
        relatadrawcolor.getBackground().setAlpha(50);
//        加载轮播图
        mbanner.setImageLoader(new MyBanner());
        listimgs.add(img1);
        listimgs.add(img2);
        listimgs.add(img3);
        listimgs.add(img4);
        listimgs.add(img5);
        mbanner.setImages(listimgs);
        mbanner.start();
        titlebar.setBackgroundColor(Color.RED);
        titlebar.setAlpha(0);
// ;
        presenter.loadDataFromServer();
        titlebar.bringToFront();
//        上滑监听事件
       mScrollview.setScrollListener(new ObserveScrollView.ScrollListener() {
           @Override
           public void scrollOritention(int l, int t, int oldl, int oldt) {

               Log.d("loaction-y","t"+t );
               if (t>0){
                   Log.d("上滑了",""+t);
               }

               if (t <= 0) {
                   titlebar.setAlpha(0);
               } else if (t > 0 && t <= 100) {
                   titlebar.setAlpha(0.3f);
               }else if (t > 100 && t <= 200){
                   titlebar.setAlpha(0.5f);
               }else if (t > 200 && t <= 300){
                    titlebar.setAlpha(0.8f);
               }else if (t > 300){
                   titlebar.setAlpha(1);
               }

           }
       });



    }

    //创建Presenter实例
    @Override
    ChoicenessPresenter newPresenter() {
        return new ChoicenessPresenter();
    }


    @Override
    public void onSuccess(ChoicenessBean choicenessBean) {
        //获取数据成功
        Log.d(TAG, "onSuccess: =======================" + choicenessBean.getMsg());
//        this.choicenessBean = choicenessBean;
        JIngxuanAdapter jIngxuanAdapter = new JIngxuanAdapter(choicenessBean.getRet().getList().get(0).getChildList(),getActivity());
        mlistview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mlistview.setAdapter(jIngxuanAdapter);
        mlistview.setNestedScrollingEnabled(false);

    }

    @Override
    public void onError(String s) {
        //获取数据失败
        Log.d(TAG, "onError: ---------" + s);
    }



}
