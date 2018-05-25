package com.example.xiaolitongxue.wieying.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Process;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;


/**
 * author：石头 on 2018/5/19 16:33
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 */
public class MyApplication extends Application {


    public final static float DESIGN_WIDTH = 720; //绘制页面时参照的设计图宽度

    private static int myTid;
    private static Handler handler;
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5b07ae51");
        resetDensity();//注意不要漏掉
//        Fresco
        Fresco.initialize(this);
//        主题
        //初始化frsco
        myTid = Process.myTid();
        handler = new Handler();
        //设置全局的Header构建器
        appContext = this;
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
//    主题
    public static int getMyTid() {
        return myTid;
    }

    public static Handler getHandler() {
        return handler;
    }
}
