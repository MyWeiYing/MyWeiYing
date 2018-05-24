package com.example.xiaolitongxue.wieying.presenter;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.xiaolitongxue.wieying.model.bean.VideoPinglunBean;
import com.example.xiaolitongxue.wieying.model.http.RetorfitUtils;
import com.example.xiaolitongxue.wieying.model.interfaces.MyService;
import com.example.xiaolitongxue.wieying.model.pinglun.PinlunModel;
import com.example.xiaolitongxue.wieying.view.fragment.BaseFragment;
import com.example.xiaolitongxue.wieying.view.interfaces.IFindPinglunView;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FindPinglunPresenter implements IFindPinglunPresenter {
    private IFindPinglunView iFindPinglunView;
    private PinlunModel pinlunModel;


    public FindPinglunPresenter(IFindPinglunView iFindPinglunView) {
        this.iFindPinglunView = iFindPinglunView;
        pinlunModel = new PinlunModel();
    }

    @Override
    public void onSuccess(VideoPinglunBean videoPinglunBean) {
        if(iFindPinglunView!=null){
            iFindPinglunView.onSuccess(videoPinglunBean);
        }
    }

    @Override
    public void onError(String message) {
        if(iFindPinglunView!=null){
            iFindPinglunView.onError(message);
        }
    }

    @Override
    public void getFindViewPinglun(String mediaId) {
        pinlunModel.getFindViewPinglun(mediaId,this);
    }

    @Override
    public void Destory() {
        if(iFindPinglunView==null){
            iFindPinglunView=null;
        }
    }
}
