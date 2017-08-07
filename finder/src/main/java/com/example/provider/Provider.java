package com.example.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016-08-04.
 */
public interface Provider {
    Context getContext(Object source);

    View findView(Object source, int id);
}
