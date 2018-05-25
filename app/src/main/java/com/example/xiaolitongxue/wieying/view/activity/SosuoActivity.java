package com.example.xiaolitongxue.wieying.view.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.view.BaseActivity;

import butterknife.BindView;

public class SosuoActivity extends BaseActivity {

    @BindView(R.id.Relatadrawcolors)
    RelativeLayout Relatadrawcolors;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        Relatadrawcolors.getBackground().setAlpha(50);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sosuo;
    }
}
