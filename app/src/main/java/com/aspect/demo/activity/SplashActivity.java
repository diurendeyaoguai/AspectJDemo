package com.aspect.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.aspect.demo.R;

/**
 * Created by Administrator on 2017/8/3.
 */

public class SplashActivity extends BaseActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            SplashActivity.this.finish();
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler.sendEmptyMessageDelayed(1,2000);
    }
}
