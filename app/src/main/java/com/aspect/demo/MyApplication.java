package com.aspect.demo;

import android.app.Application;
import android.content.Context;

import com.aspect.demo.utils.SpUtil;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MyApplication extends Application {
    private static Context mApp;
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);
    }

    public static Context getAppContext(){
        return mApp;
    }
}
