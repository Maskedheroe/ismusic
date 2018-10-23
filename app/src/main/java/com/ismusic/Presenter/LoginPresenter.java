package com.ismusic.Presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ismusic.Activity.MainActivity;
import com.ismusic.Interface.ILoginContract;
import com.ismusic.Model.Global;
import com.ismusic.Model.Profile;
import com.ismusic.Model.ResponseResult;
import com.ismusic.NetUtil.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter implements ILoginContract.Presenter,LoginApi {

    private Context mContext;

    public LoginPresenter(Context context){
        this.mContext=context;
    }

    @Override
    public Call<ResponseResult> loginCallPhone(String phone, String password) {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Global.NETBASE_MUSIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginApi loginApi = retrofit.create(LoginApi.class);

        Call<ResponseResult> call = loginApi.loginCallPhone(phone,password);

        call.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                Log.d("CODE",response.body().getCode()+"");
                try {
                    if (response.body().getCode()==200) {
                        mContext.startActivity(new Intent(mContext, MainActivity.class));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {
                Toast.makeText(mContext,"登陆失败",Toast.LENGTH_LONG);
            }
        });
        return null;
    }

    @Override
    public Call<Profile> loginEmail(String email, String password) {
        return null;
    }

    @Override
    public void loginWithPhone(String phone,String passwd) {
        loginCallPhone(phone,passwd);
    }
}
