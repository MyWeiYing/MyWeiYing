package com.example.xiaolitongxue.wieying.application;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author：石头 on 2018/5/19 16:33
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 */
public class MyApplication extends Application {


    public final static float DESIGN_WIDTH = 720; //绘制页面时参照的设计图宽度

    @Override
    public void onCreate() {
        super.onCreate();
        resetDensity();//注意不要漏掉
        Fresco.initialize(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();//这个方法重写也是很有必要的
    }

    public void resetDensity(){
        Point size = new Point();
        ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x/DESIGN_WIDTH*72f;
    }
}
