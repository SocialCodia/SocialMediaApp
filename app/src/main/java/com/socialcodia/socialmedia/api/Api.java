package com.socialcodia.socialmedia.api;

import com.socialcodia.socialmedia.pojos.ResponseDefault;
import com.socialcodia.socialmedia.pojos.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseDefault> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login(
      @Field("email") String email,
      @Field("password") String password
    );
}
