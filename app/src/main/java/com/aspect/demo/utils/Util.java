package com.aspect.demo.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/3.
 */

public class Util {
    static long time = 0;
    public static void showToast(Context context,String msg,int type){
        if(TextUtils.isEmpty(msg)) return;
        Toast toast = null;
        if(toast == null) {
            toast = Toast.makeText(context, msg, type);
            toast.show();
            time = System.currentTimeMillis();
        }else{
            if(System.currentTimeMillis() - time > 1000){
                toast.show();
                time = System.currentTimeMillis();
            }
        }
    }

    public static void showToast(Context context,String msg){
        showToast(context,msg,Toast.LENGTH_SHORT);
    }


    /**
     * @param fraction
     * @param startValue
     * @param endValue
     * @return
     */
    public static Integer evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;
        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;
        return (int) ((startA + (int) (fraction * (endA - startA))) << 24)
                | (int) ((startR + (int) (fraction * (endR - startR))) << 16)
                | (int) ((startG + (int) (fraction * (endG - startG))) << 8)
                | (int) ((startB + (int) (fraction * (endB - startB))));
    }
}
