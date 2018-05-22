package com.example.xiaolitongxue.wieying.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.BaseActivity;

public class JinxuanxiangqingActivity extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinxuanxiangqing);
//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void initData() {
        View inflate = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player,null);
        setContentView(inflate);
        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        new PlayerView(this)
                .setTitle("")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(videourl)
                .startPlay();
    }

    @Override
    protected int getLayout() {
        return R.layout.content_jinxuanxiangqing;
    }

}
