package com.aspect.demo.api;

import android.util.Log;

import com.aspect.demo.MyApplication;
import com.aspect.demo.utils.NetWorkUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/31.
 */

public class Api {
    public Retrofit retrofit;
    public ApiService service;

    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }

    Interceptor headInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder()
                    .addHeader("X-LC-Id", "i7j2k7bm26g7csk7uuegxlvfyw79gkk4p200geei8jmaevmx")
                    .addHeader("X-LC-Key", "n6elpebcs84yjeaj5ht7x0eii9z83iea8bec9szerejj7zy3")
                    .addHeader("Content-Type", "application/json")
                    .build());
        }
    };

    //构造方法私有
    private Api() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File cacheFile = new File(MyApplication.getAppContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(headInterceptor)
                .addInterceptor(logInterceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://leancloud.cn:443/1.1/")
                .build();
        service = retrofit.create(ApiService.class);
    }

    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtil.isNetConnected(MyApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("Okhttp", "no network");
            }

            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetConnected(MyApplication.getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}