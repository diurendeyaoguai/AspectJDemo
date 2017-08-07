package com.aspect.demo.presenter;

import com.aspect.demo.view.BaseView;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess();

        void signSuccess();

        void showMsg(String msg);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void login(String name, String pass);

        public abstract void sign(String name, String pass);

        @Override
        public void onAttached() {
        }
    }
}
