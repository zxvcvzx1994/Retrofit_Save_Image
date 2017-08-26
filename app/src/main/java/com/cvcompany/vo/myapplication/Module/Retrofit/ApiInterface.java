package com.cvcompany.vo.myapplication.Module.Retrofit;

import com.cvcompany.vo.myapplication.Module.Picture;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by vinh on 8/23/2017.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("inputimage.php")
    Call<Picture> getPicture(@Field("Title") String title, @Field("Image") String image);

    @POST("getimage.php")
    Call<List<Picture>> createArrayList();

}
