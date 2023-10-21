package com.socialcodia.socialmedia.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String BASE_URL = "http://10.0.2.2/api/public/";
    private static ApiClient mInstance;
    private Retrofit retrofit;

    private ApiClient()
    {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance()
    {
        if(mInstance==null)
        {
            mInstance = new ApiClient();
        }
        return mInstance;
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }

}
