package com.example.xiaolitongxue.wieying.view;

import android.graphics.Color;
import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;
import com.example.xiaolitongxue.wieying.view.custom.ObserveScrollView;
import com.example.xiaolitongxue.wieying.view.fragment.ChoicenessFragment;
import com.example.xiaolitongxue.wieying.view.fragment.FindFragment;
import com.example.xiaolitongxue.wieying.view.fragment.MyFragment;
import com.example.xiaolitongxue.wieying.view.fragment.SpecialFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ObserveScrollView.ScrollListener {

    @BindView(R.id.bottom_tabbar)
    BottomTabBar bottomTabbar;
    @BindView(R.id.main_myTileBar)
    MyTitleBar mainMyTileBar;

   /* @Override
    protected void initView() {
        //初始化控件
    }*/

    @Override
    protected void initData() {
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
}