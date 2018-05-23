package com.example.xiaolitongxue.wieying.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.BaseActivity;
import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;


import butterknife.BindView;
import butterknife.ButterKnife;

public class JinxuanxiangqingActivity extends BaseActivity {


    @BindView(R.id.player_view)
    IjkPlayerView playerView;
    @BindView(R.id.main_myTileBar)
    MyTitleBar mainMyTileBar;

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
        mainMyTileBar.setTitleBarTitle(title);
        String videourl = intent.getStringExtra("videourl");
        String pic = intent.getStringExtra("pic");
        Glide.with(this).load(pic).into(playerView.mPlayerThumb);
        Toast.makeText(this,videourl+"",Toast.LENGTH_LONG).show();
        playerView = findViewById(R.id.player_view);
        playerView.init()
                .setVideoPath(videourl)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();


    }

    @Override
    protected void onResume() {
        super.onResume();
        playerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        playerView.onPause();
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
