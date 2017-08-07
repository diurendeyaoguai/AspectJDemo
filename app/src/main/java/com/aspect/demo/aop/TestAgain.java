package com.aspect.demo.aop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2017/7/27.
 */
@Aspect
public class TestAgain {

    @Before("execution(* android.support.v7.app.AppCompatActivity.on*(android.os.Bundle))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d("zhang", "onActivityMethodBefore: " + key);
    }
}
