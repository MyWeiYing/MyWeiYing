package com.example.xiaolitongxue.wieying.model.http;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * author：石头 on 2018/5/20 20:55
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 */
public class OkhttpUtils {
    public void doget(String url, Callback call){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call1 = okHttpClient.newCall(request);
        call1.enqueue(call);
    }
}
