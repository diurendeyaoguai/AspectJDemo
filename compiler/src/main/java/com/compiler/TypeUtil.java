package com.compiler;

import com.squareup.javapoet.ClassName;

/**
 * Created by Administrator on 2016-08-04.
 */
public class TypeUtil {
    public static final ClassName ANDROID_VIEW = ClassName.get("android.view", "View");
    public static final ClassName ANDROID_ON_CLICK_LISTENER = ClassName.get("android.view", "View", "OnClickListener");
    public static final ClassName FINDER = ClassName.get("com.example", "Finder");
    public static final ClassName PROVIDER = ClassName.get("com.example.provider", "Provider");
}
