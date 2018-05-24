package com.example.xiaolitongxue.wieying.presenter;

import com.example.xiaolitongxue.wieying.model.bean.FindBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.view.interfaces.FindIView;

import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public class FindPresenter extends BasePresenter<FindIView> {

    private final RetorfitUtils retorfitUtils;

    public FindPresenter() {
        retorfitUtils = RetorfitUtils.getRetorfitUtils();
    }

    public void loadDataFromServer(Map<String,String> map){
        MyService myService = retorfitUtils.create(MyService.class);
        Observable<FindBean> findData = myService.getFindData(map);
        findData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onError(e.getMessage());
                    }

                    @Override
                    public void onNext(FindBean findBean) {
                        getView().onSuccess(findBean);
                    }
                });
    }

}
