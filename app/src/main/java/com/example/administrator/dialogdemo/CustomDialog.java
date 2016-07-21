package com.example.administrator.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xiangjian on 2016/7/19.
 */
public class CustomDialog extends Dialog {
    private int layoutRes;
    private Context ctx;
    private View view;

    protected int screenWidth;
    int screenHeight;
    private float mDensity = 1f;
    private int paddingSize = 0;

    public CustomDialog(Context context) {
        super(context);
        this.ctx = context;
    }

    /**
     * 自定义布局的构造方法
     *
     * @param context
     * @param resLayout
     */
    public CustomDialog(Context context, int resLayout) {
        super(context);
        this.ctx = context;
        this.layoutRes = resLayout;
        initView();
    }

    /**
     * 自定义主题及布局的构造方法
     *
     * @param context
     * @param theme
     * @param resLayout
     */
    public CustomDialog(Context context, int theme, int resLayout) {
        super(context, theme);
        this.ctx = context;
        this.layoutRes = resLayout;
        initView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加布局
        ViewGroup.LayoutParams viewLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        viewLayoutParams.width = screenWidth - screenWidth * 2 / 5;
        viewLayoutParams.width = screenWidth;
        viewLayoutParams.height = screenHeight;
        setContentView(this.view, viewLayoutParams);
    }

    protected void initView() {
        // 获取系统数据
        this.screenWidth = this.ctx.getResources().getDisplayMetrics().widthPixels;
        screenHeight = ctx.getResources().getDisplayMetrics().heightPixels;
        this.mDensity = this.ctx.getResources().getDisplayMetrics().density;
        this.paddingSize = (int) (6 * this.mDensity);

        // 初始化布局
        this.view = LayoutInflater.from(this.ctx).inflate(layoutRes, null);

      /*  // 设置边距
        int padding = this.screenWidth * 5 / 100;
        this.view.setPadding(padding, padding, padding, padding);*/

        // 设置点击空白处不关闭
        setCanceledOnTouchOutside(true);
    }


}