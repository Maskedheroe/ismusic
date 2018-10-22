package com.ismusic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ismusic.Interface.ILoginContract;
import com.ismusic.Presenter.LoginPresenter;
import com.ismusic.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginContract.View ,View.OnClickListener {

    private EditText userInput;
    private EditText passwordInput;
    private TextView tryoutBtn;
    private TextView loginBtn;


    private String userId;

    private String password;

    private ILoginContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    public void initView() {
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        userInput =findViewById(R.id.input_user);
        passwordInput=findViewById(R.id.input_password);
        tryoutBtn = findViewById(R.id.btn_tryout);
        loginBtn = findViewById(R.id.btn_login);
        userId=userInput.getText().toString();
        password=passwordInput.getText().toString();
        presenter= new LoginPresenter(this);
        loginBtn.setOnClickListener(this);
        tryoutBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                presenter.loginWithPhone(userId,password);
                break;
            case R.id.btn_tryout:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
                break;
        }
    }
}
