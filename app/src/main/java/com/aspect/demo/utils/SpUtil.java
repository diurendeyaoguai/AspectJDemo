package com.aspect.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.aspect.demo.model._User;
import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2017/8/3.
 */

public class SpUtil {
    static SharedPreferences sharedPreferences;
    public static void init(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static void setUser(_User user){
        sharedPreferences.edit().putString("user",new GsonBuilder().serializeNulls().create().toJson(user));
    }

    public static _User getUser(){
        return new GsonBuilder().serializeNulls().create().fromJson(sharedPreferences.getString("user",null),_User.class);
    }
}
