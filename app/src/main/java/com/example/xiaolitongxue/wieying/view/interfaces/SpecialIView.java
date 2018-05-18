package com.example.xiaolitongxue.wieying.view.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface SpecialIView extends BaseIView{
//    成功的
    void onSuccess(SpeciallBean speciallBean);
//    失败的
    void onError(String s);
}
