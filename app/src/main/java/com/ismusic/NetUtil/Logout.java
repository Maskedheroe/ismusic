package com.ismusic.NetUtil;

import com.ismusic.Model.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Logout {
    @GET("logout")
    Call<ResponseResult> logout();
}
