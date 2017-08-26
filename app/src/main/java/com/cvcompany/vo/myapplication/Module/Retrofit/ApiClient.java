package com.cvcompany.vo.myapplication.Module.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinh on 8/23/2017.
 */

public class ApiClient {
    private static Retrofit retrofit = null;
    private static  String url = "http://192.168.1.12/index/";

    public synchronized static Retrofit getRetrofit(){
        if(retrofit==null){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
