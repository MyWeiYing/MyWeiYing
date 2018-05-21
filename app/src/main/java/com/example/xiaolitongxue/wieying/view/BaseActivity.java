package com.example.xiaolitongxue.wieying.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.xiaolitongxue.wieying.view.interfaces.BaseIView;

import butterknife.ButterKnife;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseIView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

//        沉浸式
        setTranslucentStatus(true);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        ButterKnife.bind(this);
//        initView();
        initData();
    }




    //    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getLayout();
     //沉浸式
    protected void setTranslucentStatus(boolean on) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

}
