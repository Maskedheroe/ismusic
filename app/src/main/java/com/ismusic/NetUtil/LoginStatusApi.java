package com.ismusic.NetUtil;

import com.ismusic.Model.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginStatusApi {
    @GET("login/status")
    Call<ResponseResult> loginStatus();
}
