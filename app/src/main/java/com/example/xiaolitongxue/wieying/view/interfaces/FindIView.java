package com.example.xiaolitongxue.wieying.view.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.bean.FindBean;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface FindIView extends BaseIView{
    void onSuccess(FindBean findBean);
    void onError(String error);
}
