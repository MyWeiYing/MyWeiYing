package com.example.xiaolitongxue.wieying.model.pinglun;

import com.example.xiaolitongxue.wieying.model.bean.FindBean;
import com.example.xiaolitongxue.wieying.model.bean.VideoPinglunBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.presenter.IFindPinglunPresenter;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PinlunModel implements IPinlunModel {


    @Override
    public void getFindViewPinglun(String mediaId, final IFindPinglunPresenter iFindPinglunPresenter) {
        RetorfitUtils retorfitUtils = RetorfitUtils.getRetorfitUtils();
        MyService myService = retorfitUtils.create(MyService.class);
        Observable<VideoPinglunBean> findData = myService.getFindPinglun(mediaId);
        findData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoPinglunBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iFindPinglunPresenter.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoPinglunBean videoPinglunBean) {
                        iFindPinglunPresenter.onSuccess(videoPinglunBean);
                    }
                });
    }
}
