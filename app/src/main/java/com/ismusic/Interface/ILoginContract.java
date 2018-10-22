package com.ismusic.Interface;

public interface ILoginContract {
    interface Presenter{
        void loginWithPhone(String phone,String passwd);
    }
    interface View extends IView{

    }
}
