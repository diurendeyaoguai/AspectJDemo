package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016-08-03.
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnClick {
    int[] value();
}
