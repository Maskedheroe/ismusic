package com.ismusic.Component;

import com.ismusic.Activity.LoginActivity;
import com.ismusic.Presenter.LoginPresenter;

import dagger.Component;

@Component
public interface LoginComponent {
    void inject(LoginPresenter presenter);
}
