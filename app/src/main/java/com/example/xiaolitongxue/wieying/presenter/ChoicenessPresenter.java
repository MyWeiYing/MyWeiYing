package com.example.xiaolitongxue.wieying.presenter;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.view.interfaces.ChoicenessIView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public class ChoicenessPresenter extends BasePresenter<ChoicenessIView>{
    private final RetorfitUtils retorfitUtils;


    public ChoicenessPresenter() {
        retorfitUtils = RetorfitUtils.getRetorfitUtils();
    }
    public void loadDataFromServer(){
        MyService myService = retorfitUtils.create(MyService.class);
        myService.getChoicenessData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChoicenessBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                     getView().onError(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(ChoicenessBean choicenessBean) {
                     getView().onSuccess(choicenessBean);
                    }
                });

    }

}
