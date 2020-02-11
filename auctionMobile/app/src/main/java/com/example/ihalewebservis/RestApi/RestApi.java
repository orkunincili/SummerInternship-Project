package com.example.ihalewebservis.RestApi;

import com.example.ihalewebservis.Models.Bilgiler;
import com.example.ihalewebservis.Models.Price;
import com.example.ihalewebservis.Models.deleteUser;
import com.example.ihalewebservis.Models.user;
import com.example.ihalewebservis.Models.onlineUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {



    @GET("api/price/?format=json")
    Call<List<Price>> getPrice();

    @GET("api/ihaleler/?format=json")
    Call<List<Bilgiler>> bilgiGetir();

    @FormUrlEncoded
    @POST("/api/user/")
    Call<user> addUser(@Field("username") String ad, @Field("price") String price,@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("/api/onlineuser/")
    Call<onlineUser> addOnline(@Field("online_user") String user);

    @FormUrlEncoded
    @POST("api/delete_user/")
    Call<deleteUser> deleteUser(@Field("user_id") String user_id);



}



