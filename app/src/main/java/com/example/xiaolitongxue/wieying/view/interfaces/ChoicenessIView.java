package com.example.xiaolitongxue.wieying.view.interfaces;

import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;

/**
 * Created by xiaolitongxue on 2018/5/16.
 */

public interface ChoicenessIView extends BaseIView{
    void onSuccess(ChoicenessBean choicenessBean);
    void onError(String s);
}
