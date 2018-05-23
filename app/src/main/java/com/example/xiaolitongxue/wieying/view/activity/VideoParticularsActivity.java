package com.example.xiaolitongxue.wieying.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dl7.player.media.IjkPlayerView;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 视频详情 Activity
 */
public class VideoParticularsActivity extends BaseActivity {


    @BindView(R.id.player_view)
    IjkPlayerView mPlayerView;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String shareURL = intent.getStringExtra("ShareURL");

        Toast.makeText(this, ""+shareURL, Toast.LENGTH_SHORT).show();
        Log.d("VideoParticularsActivit", ""+shareURL);
        mPlayerView = (IjkPlayerView)
        findViewById(R.id.player_view);

        Uri mUri = Uri.parse("http://covertness.qiniudn" + ".com/android_zaixianyingyinbofangqi_test_baseline.mp4");

        mPlayerView.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_video_particulars;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPlayerView.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
