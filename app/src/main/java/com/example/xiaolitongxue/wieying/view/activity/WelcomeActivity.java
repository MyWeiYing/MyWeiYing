package com.example.xiaolitongxue.wieying.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 欢迎界面
 *  1.三秒跳转
 *  2.属性动画
 */
public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.welcome_img)
    ImageView welcomeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    timer();
    }

    private void timer() {
        final Intent intent = new Intent(this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };
        timer.schedule(timerTask,1000*3);

    }
}
