package com.example.xiaolitongxue.wieying.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.BaseActivity;
import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;
import com.example.xiaolitongxue.wieying.view.fragment.Jingxuanxiangqing_tablayout_fragmentvp;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JinxuanxiangqingActivity extends BaseActivity {

    String[] str = {"简介", "评论"};
    private FragmentManager fm;
    private MyvpAdapter adapter;
    private ArrayList<Jingxuanxiangqing_tablayout_fragmentvp> fragmentvps;


    @BindView(R.id.player_view)
    IjkPlayerView playerView;
    @BindView(R.id.main_myTileBar)
    MyTitleBar mainMyTileBar;
    @BindView(R.id.mtablayout)
    TabLayout mtablayout;
    @BindView(R.id.mviewpager)
    ViewPager mviewpager;
    private String description;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        if(title!=null){
            mainMyTileBar.setTitleBarTitle(title);
        }
        String videourl = intent.getStringExtra("videourl");
        description = intent.getStringExtra("description");
        String pic = intent.getStringExtra("pic");
        if (pic!=null){
            Glide.with(this).load(pic).into(playerView.mPlayerThumb);
        }
        Toast.makeText(this, videourl + "", Toast.LENGTH_LONG).show();
        playerView = findViewById(R.id.player_view);
        Log.d("test",videourl + "dasf");
        if (videourl!=null && !"".equals(videourl)) {
            playerView.init()
                    .setVideoPath(videourl)
                    .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                    .enableDanmaku()
                    .start();
        }

        Tablay();

    }

    //Tablayout
    private void Tablay() {
        fragmentvps = new ArrayList<>();
        fm = getSupportFragmentManager();
        for (int i = 0; i < str.length; i++) {
            Jingxuanxiangqing_tablayout_fragmentvp fragmentvp = new Jingxuanxiangqing_tablayout_fragmentvp();
            Bundle b = new Bundle();
            b.putString("data", str[i]);
            if(description!=null){
                b.putString("description",description);
            }
//            b.putString("dataurl",urlS[i]);
            fragmentvp.setArguments(b);
            fragmentvps.add(fragmentvp);
            //加载横向滚动
            mtablayout.addTab(mtablayout.newTab().setText(str[i]));
        }
        adapter = new MyvpAdapter(fm);
        mviewpager.setAdapter(adapter);
        mtablayout.setupWithViewPager(mviewpager);
    }
    //适配器
    class MyvpAdapter extends FragmentPagerAdapter {


        public MyvpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentvps.get(position);
        }

        @Override
        public int getCount() {
            return fragmentvps.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }


    //ijplay结合生命周期
    @Override
    protected void onResume() {
        super.onResume();
        playerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (playerView != null && playerView.isPlaying()){
            playerView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        playerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        playerView.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (playerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (playerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_jinxuanxiangqing;
    }

}
