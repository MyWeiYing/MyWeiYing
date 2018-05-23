package com.example.xiaolitongxue.wieying.model.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.bean.FindBean;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallClassifyBean;


import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface MyService {
    //    精选
    @POST("front/homePageApi/homePage.do")
    Observable<ChoicenessBean> getChoicenessData();

    //    专题
    @FormUrlEncoded
    @POST("/front/columns/getVideoList.do")
    Observable<SpeciallBean> getSpeciallData(@FieldMap Map<String,String> map);


    @FormUrlEncoded
    @POST("front/columns/getVideoList.do")
    Observable<FindBean> getFindData(@FieldMap Map<String,String> map);

/*    //    专题 Classify
    @FormUrlEncoded
    @POST("/front/columns/getVideoList.do")
    Observable<SpeciallClassifyBean> getSpeciallClassData(@FieldMap Map<String,String> map);*/
}
