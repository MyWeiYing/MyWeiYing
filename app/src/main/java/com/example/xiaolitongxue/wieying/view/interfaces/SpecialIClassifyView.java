package com.example.xiaolitongxue.wieying.view.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.SpeciallClassifyBean;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface SpecialIClassifyView extends BaseIView{
//    成功的
    void onSuccess(SpeciallClassifyBean speciallJumpBean);
//    失败的
    void onError(String s);
}
