package com.ismusic.Interface;

public interface IStartContract {
    interface Presenter{
        void startTimer();
        void stopTimer();
    }
    interface View extends IView{
        void setSkipText(String str);
        void sendHandleMessage(int n);
    }
}
