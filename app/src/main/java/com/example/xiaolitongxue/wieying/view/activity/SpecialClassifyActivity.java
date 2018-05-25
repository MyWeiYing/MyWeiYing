package com.example.xiaolitongxue.wieying.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallClassifyBean;
import com.example.xiaolitongxue.wieying.model.http.OkhttpUtils;
import com.example.xiaolitongxue.wieying.view.BaseActivity;
import com.example.xiaolitongxue.wieying.view.adapter.SpecialClassifyAdapter;
import com.example.xiaolitongxue.wieying.view.custom.MyTitleBar;
import com.example.xiaolitongxue.wieying.view.interfaces.SpecialIClassifyView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SpecialClassifyActivity extends BaseActivity implements SpecialIClassifyView {
    private Handler handler = new Handler();
    @BindView(R.id.special_activity_myTileBar)
    MyTitleBar specialActivityMyTileBar;
    @BindView(R.id.special_classify_recycler)
    RecyclerView specialClassifyRecycler;
    private SpecialClassifyAdapter specialClassifyAdapter;
    private List<SpeciallClassifyBean.RetBean.ListBean> list;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        specialActivityMyTileBar.setTitleBarTitle(title);
//        标题栏是否显示
        specialActivityMyTileBar.setTitleBarReturn(true);
//        返回的点击事件
        specialActivityMyTileBar.setReturnClickListener(new MyTitleBar.ReturnClickListener() {
            @Override
            public void returnClickListener() {
                finish();
            }
        });
//        给定颜色 为红色
        specialActivityMyTileBar.setBackgroundColor(Color.RED);
        final String loadURL = intent.getStringExtra("loadURL");

        final OkhttpUtils okhttpUtils = new OkhttpUtils();
        new Thread(new Runnable() {
            @Override
            public void run() {

                okhttpUtils.doget(loadURL, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Gson gson = new Gson();
                        final SpeciallClassifyBean speciallClassifyBean = gson.fromJson(string, SpeciallClassifyBean.class);
                        Log.d("aaa", speciallClassifyBean.getMsg() + "");
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                specialClassifyAdapter = new SpecialClassifyAdapter(speciallClassifyBean.getRet().getList(), SpecialClassifyActivity.this);
                                specialClassifyRecycler.setLayoutManager(new GridLayoutManager(SpecialClassifyActivity.this, 2));
                                specialClassifyRecycler.setAdapter(specialClassifyAdapter);
                            }
                        });
                    }
                });
            }
        }).start();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_special_classify;
    }

    //成功
    @Override
    public void onSuccess(SpeciallClassifyBean speciallClassifyBean) {

    }

    //失败
    @Override
    public void onError(String s) {

    }
}
