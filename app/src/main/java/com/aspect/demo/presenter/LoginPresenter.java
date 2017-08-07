package com.aspect.demo.presenter;

import android.util.Log;

import com.aspect.demo.api.Api;
import com.aspect.demo.model._User;
import com.aspect.demo.utils.SpUtil;
import com.aspect.demo.view.LoginView;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/1.
 */

public class LoginPresenter extends LoginContract.Presenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;

        loginView.setPresenter(this);
    }


    @Override
    public void login(String name, String pass) {
        loginView.showProgressBar();
        Flowable<_User> userFlowable = Api.getInstance().service.login(name,pass);
        CompositeDisposable mCompositeSubscription = new CompositeDisposable();
        mCompositeSubscription.add(userFlowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<_User>() {
            @Override
            public void accept(@NonNull _User user) throws Exception {
                loginView.hideProgressBar();
                SpUtil.setUser(user);
                loginView.loginResult(0);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                loginView.hideProgressBar();
                loginView.loginResult(1);
            }
        }));
    }

    @Override
    public void sign(String name, String pass) {

    }
}
