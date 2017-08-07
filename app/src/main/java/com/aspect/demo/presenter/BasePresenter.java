package com.aspect.demo.presenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Administrator on 2017/8/1.
 */

public abstract class BasePresenter<V> {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    V mView;
    public void setView(V v) {
        this.mView = v;
        this.onAttached();
    }
    abstract void onAttached();
    public void onDetached(){
        compositeDisposable.dispose();
    }
}
