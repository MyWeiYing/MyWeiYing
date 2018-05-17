package com.example.xiaolitongxue.wieying.model.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public class RetorfitUtils {
    private static  RetorfitUtils retorfitUtils;
    private Retrofit retrofit;
    public static RetorfitUtils getRetorfitUtils(){
        if (retorfitUtils==null){
            synchronized (RetorfitUtils.class){
                if (retorfitUtils==null){
                    return retorfitUtils = new RetorfitUtils();
                }

            }

        }
        return retorfitUtils = new RetorfitUtils();
    }
    public RetorfitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

    }

    public <T> T create(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }




}
