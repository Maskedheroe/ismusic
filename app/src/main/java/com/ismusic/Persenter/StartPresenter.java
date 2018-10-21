package com.ismusic.Persenter;

import android.os.CountDownTimer;

import com.ismusic.Interface.IStartContract;

public class StartPresenter implements IStartContract.Presenter{
//    判断是否首次进入
    private boolean isFirstIn =false;
//    总时长
    private int totalTime = 5000;

    private IStartContract.View startView;

    private static final int GO_HOME = 1001;
    private static final int GO_GUIDE = 1002;

    public StartPresenter(IStartContract.View startView){
        this.startView=startView;
    }

//    定时器
    public CountDownTimer countDownTimer = new CountDownTimer(totalTime,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            if (millisUntilFinished<=1000){
                countDownTimer.onFinish();
                countDownTimer.cancel();
            }
            startView.setSkipText("跳过"+millisUntilFinished/1000+"S");
        }

        @Override
        public void onFinish() {
            if (!isFirstIn){
                startView.sendHandleMessage(GO_HOME);
            }else {
                startView.sendHandleMessage(GO_GUIDE);
            }
        }
    };


    @Override
    public void startTimer() {
        countDownTimer.start();
    }

    @Override
    public void stopTimer() {
        countDownTimer.onFinish();
        countDownTimer.cancel();
    }
}
