package com.aspect.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.ViewFinder;


/**
 * Created by Administrator on 2017/8/3.
 */

public class BaseActivity extends AppCompatActivity {
    protected ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ViewFinder.inject(this);
        createProgressBar(this);
    }

    /**
     * 动态创建ProgressBar
     * @param a
     * @return
     */
    public void createProgressBar(Activity a)
    {
//        1.找到activity根部的ViewGroup，类型都为FrameLayout。
        FrameLayout rootContainer = (FrameLayout) a.findViewById(android.R.id.content);//固定写法，返回根视图
//        2.初始化控件显示的位置
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.CENTER;
//        3.设置控件显示位置
        progressBar = new ProgressBar(a);
        progressBar.setLayoutParams(lp);
        progressBar.setVisibility(View.GONE);//默认不显示
//        4.将控件加到根节点下
        rootContainer.addView(progressBar);

    }
}
