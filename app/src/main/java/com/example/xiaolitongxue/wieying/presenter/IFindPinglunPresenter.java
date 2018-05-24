package com.example.xiaolitongxue.wieying.presenter;

import com.example.xiaolitongxue.wieying.model.bean.VideoPinglunBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.view.interfaces.IFindPinglunView;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public interface IFindPinglunPresenter {
    void onSuccess(VideoPinglunBean data);
    void onError(String message);
    void getFindViewPinglun(String mediaId);
    void Destory();
}
