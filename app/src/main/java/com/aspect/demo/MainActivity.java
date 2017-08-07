package com.aspect.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aspect.annotion.Test;
import com.aspect.demo.api.Api;
import com.aspect.demo.base.entity.CreatedResult;
import com.aspect.demo.model._User;
import com.google.gson.JsonElement;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
        testsync();
    }

    private void testsync() {
                /*Call<CreatedResult> createdResultCall = Api.getInstance().service.createUser(new _User("xxxxx","xxxxxxx"));
                createdResultCall.enqueue(new Callback<CreatedResult>() {
                    @Override
                    public void onResponse(Call<CreatedResult> call, Response<CreatedResult> response) {
                        Log.e("zhang",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<CreatedResult> call, Throwable t) {
                        Log.e("zhang",t.toString());
                    }
                });*/


                /*userFlowable.enqueue(new Callback<_User>() {
                    @Override
                    public void onResponse(Call<_User> call, Response<_User> response) {
                        Log.e("zhang",response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<_User> call, Throwable t) {
                        Log.e("zhang",t.toString());

                    }
                });*/
    }

    @Test
    public void test(){
        Log.e("zhang","LLLLL");
    }
}
