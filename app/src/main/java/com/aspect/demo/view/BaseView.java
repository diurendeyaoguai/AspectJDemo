package com.aspect.demo.view;

import com.aspect.demo.presenter.BasePresenter;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface BaseView {
    void showProgressBar();
    void hideProgressBar();
    void setPresenter(BasePresenter basePresenter);
}
