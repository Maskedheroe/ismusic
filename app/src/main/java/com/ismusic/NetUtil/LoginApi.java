package com.ismusic.NetUtil;

import com.ismusic.Model.Profile;
import com.ismusic.Model.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {
    @GET("login/cellphone")
    Call<ResponseResult> loginCallPhone(@Query("phone") String phone, @Query("password") String password);

    @GET("login")
    Call<Profile> loginEmail(@Query("email")String email,@Query("password")String password);
}
