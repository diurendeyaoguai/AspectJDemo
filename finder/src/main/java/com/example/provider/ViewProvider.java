package com.example.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016-08-04.
 */
public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object source) {
        return ((View) source).getContext();
    }

    @Override
    public View findView(Object source, int id) {
        return ((View) source).findViewById(id);
    }
}
