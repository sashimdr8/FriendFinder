package com.example.brain.friendfinder.auth.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivityLoginBinding;
import com.example.brain.friendfinder.utils.Utils;

/**
 * Created by brain on 1/19/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    LoginContract.Presenter presenter;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        new LoginPresenter(FriendFinderApp.component(LoginActivity.this),this);
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUserName.getText().toString();
                String password = binding.etPassword.getText().toString();
                presenter.login(username,password);
                Utils.hideKeyPad(binding.getRoot());

            }
        });



    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }

    @Override
    public void showLoginSuccess(String email) {
        Utils.showToast(this,"Login Successful \n Welcome "+email);
    }

    @Override
    public void showLoginError(String error) {
        Utils.showToast(this,error);

    }
}
