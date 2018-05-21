package com.example.xiaolitongxue.wieying.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObserveScrollView extends ScrollView {
    private ScrollListener mListener;

    public static interface ScrollListener {//声明接口，用于传递数据
        public void scrollOritention(int l, int t, int oldl, int oldt);
    }

    public ObserveScrollView(Context context, AttributeSet attrs,
                             int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObserveScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObserveScrollView(Context context) {
        super(context);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        super.onScrollChanged(l, t, oldl, oldt);
        if (mListener != null) {
            mListener.scrollOritention(l, t, oldl, oldt);
        }
    }

    public void setScrollListener(ScrollListener l) {
        this.mListener = l;
    }
}
