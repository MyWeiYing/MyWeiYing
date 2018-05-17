package com.example.xiaolitongxue.wieying.model.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;


import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface MyService {
    @POST("front/homePageApi/homePage.do")
    Observable<ChoicenessBean> getChoicenessData();


}
