package com.ismusic.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ismusic.Interface.IStartContract;
import com.ismusic.Interface.IView;
import com.ismusic.MainActivity;
import com.ismusic.Persenter.StartPresenter;
import com.ismusic.R;

public class StartActivity extends AppCompatActivity implements IStartContract.View,View.OnClickListener {

    private ImageView coverImage;
    private TextView skipButton;
    private IStartContract.Presenter startPresenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        startPresenter.startTimer();

    }


    @Override
    public void initView() {
        coverImage = findViewById(R.id.cover_image);
        skipButton = findViewById(R.id.skip_button);
        skipButton.setOnClickListener(this);
        startPresenter = new StartPresenter(this);
        Glide.with(this)
                .load("https://bing.ioliu.cn/v1?w=1080&h=1920")
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .centerCrop())
                .into(coverImage);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.skip_button:
                startPresenter.stopTimer();
                startActivity(new Intent(StartActivity.this,MainActivity.class));
        }
    }


    @Override
    public void setSkipText(String str) {
        skipButton.setText(str);
    }

    @Override
    public void sendHandleMessage(int n) {
        handler.sendEmptyMessage(n);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1001:
                    startActivity(new Intent(StartActivity.this,MainActivity.class));
                    finish();
                    break;
                case 1002:
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
