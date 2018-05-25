package com.example.xiaolitongxue.wieying.model.bean;

import java.util.ArrayList;

/**
 * author：石头 on 2018/5/25 14:55
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输
 * 讯飞语音
 */
public class XFBean {
    public ArrayList<WS> ws;
    public class WS{
        public ArrayList<CW> cw;
    }
    public class CW{
        public String w;
    }
}
