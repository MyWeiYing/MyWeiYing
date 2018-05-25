package com.example.xiaolitongxue.wieying.view.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
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
 * 1.三秒跳转
 * 2.属性动画
 */
public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.welcome_img)
    ImageView welcomeImg;

    private int[] imgs = new int[]{R.drawable.show_a,R.drawable.show_b,R.drawable.show_c,R.drawable.show_d,R.drawable.show_e,R.drawable.show_f,R.drawable.show_g};
    private int welcome_img_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        SharedPreferences six = getSharedPreferences("six", MODE_PRIVATE);
        welcome_img_id = six.getInt("welcome_img_id", -1);
        if (welcome_img_id == -1){
            six.edit().putInt("welcome_img_id",1).commit();
            welcomeImg.setImageResource(imgs[0]);
        }else {
            welcomeImg.setImageResource(imgs[welcome_img_id]);
            if (welcome_img_id == imgs.length - 1){
                welcome_img_id = 0;
                six.edit().putInt("welcome_img_id",0).commit();
            }
            six.edit().putInt("welcome_img_id",welcome_img_id + 1).commit();
        }
        timer();
//        动画
        animation();
    }

    private void animation() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(welcomeImg, "scaleX", 1f, 1.3f, 1.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(welcomeImg, "scaleY", 1f, 1.3f, 1.8f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleX).with(scaleY);
        animatorSet.setDuration(1000 * 3)
                .start();
    }

    private void timer() {
        final Intent intent = new Intent(this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, 1000 * 3);

    }
}
