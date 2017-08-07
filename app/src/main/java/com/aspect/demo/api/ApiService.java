package com.aspect.demo.api;

import com.aspect.demo.base.entity.CreatedResult;
import com.aspect.demo.model.CommentInfo;
import com.aspect.demo.model.ImageInfo;
import com.aspect.demo.model._User;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/31.
 */
@ApiFactory
public interface ApiService {
    @GET("login")
    Flowable<_User> login(@Query("username") String username, @Query("password") String password);

    @POST("users")
    Call<CreatedResult> createUser(@Body _User user);
}

