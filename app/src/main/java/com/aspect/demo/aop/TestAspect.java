package com.aspect.demo.aop;

import android.util.Log;
import android.widget.Toast;

import com.aspect.demo.MyApplication;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/7/27.
 */
@Aspect
public class TestAspect {
    @Pointcut("execution(@com.aspect.annotion.Test * *(..))")//方法切入点
    public void methodAnnotated(){

    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e("zhang","这tm都是啥");
        Toast.makeText(MyApplication.getAppContext(),"这tm都是啥",Toast.LENGTH_SHORT).show();
        joinPoint.proceed();//执行原方法
    }
}
