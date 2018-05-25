package com.example.xiaolitongxue.wieying.view;

import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.RelativeLayout;


import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import android.widget.TextView;

import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.adapter.ThemeAdapter;
import com.example.xiaolitongxue.wieying.view.custom.CommonUtil;
import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;
import com.example.xiaolitongxue.wieying.view.custom.NetTypeUtils;
import com.example.xiaolitongxue.wieying.view.custom.ObserveScrollView;
import com.example.xiaolitongxue.wieying.view.custom.ResideLayout;
import com.example.xiaolitongxue.wieying.view.fragment.ChoicenessFragment;
import com.example.xiaolitongxue.wieying.view.fragment.FindFragment;
import com.example.xiaolitongxue.wieying.view.fragment.MyFragment;
import com.example.xiaolitongxue.wieying.view.fragment.SpecialFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jaeger.library.StatusBarUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ObserveScrollView.ScrollListener, View.OnClickListener {

    @BindView(R.id.bottom_tabbar)
    BottomTabBar bottomTabbar;
    @BindView(R.id.main_myTileBar)
    MyTitleBar mainMyTileBar;
    @BindView(R.id.avatar)
    RoundedImageView avatar;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.tv_collect)
    TextView tvCollect;
    @BindView(R.id.tv_mydown)
    TextView tvMydown;
    @BindView(R.id.tv_fuli)
    TextView tvFuli;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.theme)
    TextView theme;
    @BindView(R.id.main_parent_Layout)
    ResideLayout maxParent;
    @BindView(R.id.main_drawable_layout)
    RelativeLayout relativeLayout;
    private float alpha = 0;

    private View view1;
   /* @Override
    protected void initView() {
        //初始化控件
    }*/


    @Override
    protected void initData() {


        //首先判断有没有连接网络
        boolean result = NetTypeUtils.isConn(MainActivity.this);
        if (result) {
            //进行请求网络  数据（HttpUrl）
        } else {
            NetTypeUtils.openNetSettingDg(MainActivity.this);
        }
        avatar.setOnClickListener(this);
        desc.setOnClickListener(this);
        tvCollect.setOnClickListener(this);
        tvMydown.setOnClickListener(this);
        tvFuli.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvFeedback.setOnClickListener(this);
        tvSetting.setOnClickListener(this);
        about.setOnClickListener(this);
        theme.setOnClickListener(this);
        mainMyTileBar.setAlpha(alpha);
        mainMyTileBar.setBackgroundColor(Color.RED);
        //初始化数据
        bottomTabbar.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setFontSize(14)
                .setTabPadding(40, 0, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .setTabPadding(40, 0, 0)
                .setChangeColor(Color.RED, Color.DKGRAY)


                .setTabPadding(40, 0, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)

                .setTabPadding(40, 0, 0)
                .setChangeColor(Color.RED, Color.DKGRAY)

                .setTabBarBackgroundResource(R.drawable.bottom_bg)
                .addTabItem("精选", R.drawable.found_select, R.drawable.found, ChoicenessFragment.class)
                .addTabItem("专题", R.drawable.special_select, R.drawable.special, SpecialFragment.class)
                .addTabItem("发现", R.drawable.fancy_select, R.drawable.fancy, FindFragment.class)
                .addTabItem("我的", R.drawable.my_select, R.drawable.my, MyFragment.class)
//                .setTabPadding(20,6,10)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        mainMyTileBar.setTitleBarTitle(name);
                        if (position == 0) {
                            mainMyTileBar.setMyTitleAlpha(0);

                        }
                    }
                });
//            mainMyTileBar.setBackgroundColor(Color.YELLOW);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void scrollOritention(int l, int t, int oldl, int oldt) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.avatar:
                Toast.makeText(MainActivity.this, "我是头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.desc:
                //微影，微一下

                break;
            case R.id.tv_collect:
                //收藏

                break;
            case R.id.tv_mydown:
                //下载
                break;
            case R.id.tv_fuli:
                //福利
                break;
            case R.id.tv_share:
                //分享
                break;
            case R.id.tv_feedback:
                //建议反馈
                break;
            case R.id.tv_setting:
                //设置
                break;
            case R.id.about:
                //关于
                break;
            case R.id.theme:
                //主题
                showSelectThemes();
                break;

        }
    }

    //主题
    public ArrayList<Integer> getColorData() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.color.colorBluePrimaryDark);
        integers.add(R.color.colorAccent);
        integers.add(R.color.colorTealPrimary);
        integers.add(R.color.colorDeepOrangePrimary);
        integers.add(R.color.colorRedPrimaryCenter);
        integers.add(R.color.colorRedPrimary);
        integers.add(R.color.colorPrimaryDark);
        integers.add(R.color.colorPrimary);
        integers.add(R.color.colorLimePrimaryCenter);
        integers.add(R.color.colorOrangePrimary);
        integers.add(R.color.colorSecondText);
        integers.add(R.color.colorLimePrimaryDark);
        integers.add(R.color.colorDeepPurplePrimaryCenter);
        integers.add(R.color.colorHint);
        integers.add(R.color.colorDeepOrangePrimaryCenter);
        integers.add(R.color.colorSecondText);

        return integers;
    }

    private int clickPosition = 0;

    public void showSelectThemes() {
        clickPosition = 0;
        final ArrayList<Integer> colorData = getColorData();
        view1 = View.inflate(this, R.layout.theme_view, null);
        GridView gridView = view1.findViewById(R.id.theme_gridView);
        final ThemeAdapter themeAdapter = new ThemeAdapter(getColorData(), 0, this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                themeAdapter.setPosition(position);
                clickPosition = position;
                themeAdapter.notifyDataSetChanged();
                int colorId = colorData.get(position);
                relativeLayout.setBackgroundColor(getResources().getColor(colorId));
                maxParent.setBackgroundColor(getResources().getColor(colorId));
            }
        });
        gridView.setAdapter(themeAdapter);

        new AlertDialog.Builder(this)
                .setView(view1)
                .setPositiveButton("取消", null)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int color = getResources().getColor(colorData.get(clickPosition));
                        StatusBarUtil.setColor(MainActivity.this, color);
                        if (view1 != null)
                            view1.setBackgroundColor(color);
                        CommonUtil.saveColorValue(color);
                    }
                })
                .create()
                .show();
    }
}