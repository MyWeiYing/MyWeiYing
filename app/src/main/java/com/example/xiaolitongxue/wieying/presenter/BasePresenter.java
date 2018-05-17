package com.example.xiaolitongxue.wieying.presenter;

import com.example.xiaolitongxue.wieying.view.interfaces.BaseIView;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public class BasePresenter<V extends BaseIView> {
    private V v;
    public void attachView(V baseiview){
        this.v = baseiview;
    }
    public void detachView(){
        v = null;
    }

    public V getView(){
        return v;
    }



}
