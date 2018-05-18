package com.example.xiaolitongxue.wieying.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaolitongxue.wieying.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTitleBar extends LinearLayout {

    @BindView(R.id.titleBar_return)
    TextView titleBarReturn;
    @BindView(R.id.titleBar_title)
    TextView titleBarTitle;
    @BindView(R.id.titleBar_function_text)
    TextView titleBarFunctionText;
    @BindView(R.id.titleBar_function_img)
    ImageView titleBarFunctionImg;

    private View myTitle;
    private ReturnClickListener returnClickListener;
    private FunctionImgClickListener functionImgClickListener;
    private FunctionTextClickListener functionTextClickListener;

    public MyTitleBar(Context context) {
        this(context, null);
    }

    public MyTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myTitle = LayoutInflater.from(context).inflate(R.layout.titlebar_layout, this);//加载布局
        ButterKnife.bind(myTitle);//绑定

    }


    /**
     * 设置标题栏透明度    若标题栏透明度小于1  那么设置按钮不可点击，不响应监听事件
     * @param alpha  透明度 取值范围为 0-1
     * */
    public void setMyTitleAlpha(float alpha){
        myTitle.setAlpha(alpha);
        if (alpha != 1){
            titleBarFunctionText.setClickable(false);
            titleBarFunctionImg.setClickable(false);
            titleBarReturn.setClickable(false);
        }else {
            titleBarFunctionText.setClickable(true);
            titleBarFunctionImg.setClickable(true);
            titleBarReturn.setClickable(true);
        }
    }

    /**
     * 设置返回键是否显示
     *
     * @param isVisibility 是否显示
     */
    public void setTitleBarReturn(boolean isVisibility) {
        if (isVisibility) {
            titleBarReturn.setVisibility(VISIBLE);
        } else {
            titleBarReturn.setVisibility(GONE);
        }
    }

    /**
     * 设置标题栏右侧文字
     *
     * @param isVisibility 是否显示  true 显示  false 不显示
     * @param function     设置显示的文字
     */
    public void setTitleBarFunctionText(boolean isVisibility, String function) {
        if (isVisibility) {
            titleBarFunctionText.setVisibility(View.VISIBLE);
        } else {
            titleBarFunctionText.setVisibility(View.GONE);
        }
        titleBarFunctionText.setText(function);
    }

    /**
     * 设置标题栏右侧图片
     *
     * @param isVisibility 是否显示  true 显示  false 不显示
     * @param url          设置图片路径   drawable or mipmap
     */
    public void setTitleBarFunctionImg(boolean isVisibility, int url) {
        if (isVisibility) {
            titleBarFunctionImg.setVisibility(View.VISIBLE);
        } else {
            titleBarFunctionImg.setVisibility(View.GONE);
        }
        titleBarFunctionImg.setImageResource(url);
    }

    /**
     * 设置标题文字
     *
     * @param title 标题栏内容
     */
    public void setTitleBarTitle(String title) {
        titleBarTitle.setText(title);
    }


    @OnClick({R.id.titleBar_function_text, R.id.titleBar_function_img, R.id.titleBar_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titleBar_function_text:
                if (functionTextClickListener != null) {
                    functionTextClickListener.functionTextClickListener();//右侧文字的点击监听
                }
                break;
            case R.id.titleBar_function_img:
                if (functionImgClickListener != null) {
                    functionImgClickListener.functionImgClickListener();//右侧图片点击的监听
                }
                break;
            case R.id.titleBar_return:
                if (returnClickListener != null) {
                    returnClickListener.returnClickListener();//返回的接口回调
                }
                break;
        }
    }

    /**
     * 设置标题栏右侧文字点击监听
     * */
    public void setFunctionTextClickListener(FunctionTextClickListener functionTextClickListener) {
        this.functionTextClickListener = functionTextClickListener;
    }

    public interface FunctionTextClickListener {
        void functionTextClickListener();
    }

    /**
     * 右侧为图片时的点击监听
     */
    public void setFunctionImgClickListener(FunctionImgClickListener functionImgClickListener) {
        this.functionImgClickListener = functionImgClickListener;
    }

    public interface FunctionImgClickListener {
        void functionImgClickListener();
    }

    /**
     * 返回按钮的点击监听
     */
    public void setReturnClickListener(ReturnClickListener returnClickListener) {
        this.returnClickListener = returnClickListener;
    }

    public interface ReturnClickListener {
        void returnClickListener();
    }

}