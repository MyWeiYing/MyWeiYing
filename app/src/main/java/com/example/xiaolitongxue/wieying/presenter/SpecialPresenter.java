package com.example.xiaolitongxue.wieying.presenter;

import android.util.Log;
import android.view.View;

import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.view.interfaces.SpecialIView;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaolitongxue on 2018/5/16.
 * 专题
 */

public class SpecialPresenter extends BasePresenter<SpecialIView> {
    private static final String TAG = "Special";
    private static final RetorfitUtils retorfitUtils;
    static {
        retorfitUtils = RetorfitUtils.getRetorfitUtils();
    }

    public void loadDataFragmentServer(Map<String,String> map) {
        MyService myService = retorfitUtils.create(MyService.class);
        myService.getSpeciallData(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SpeciallBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TAG", " P层专题请求-成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onError(e.getMessage());
                    }

                    @Override
                    public void onNext(SpeciallBean speciallBean) {
                        getView().onSuccess(speciallBean);
                    }
                });
    }
}
