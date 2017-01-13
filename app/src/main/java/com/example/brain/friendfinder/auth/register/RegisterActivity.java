package com.example.brain.friendfinder.auth.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivityRegisterBinding;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private RegisterContract.Presenter presenter;
    private ActivityRegisterBinding binding;
    private FriendFinderModule module;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        new RegisterPresenter(FriendFinderApp.component(this),this);
        binding.btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.signUp("username","password");
            }
        });


    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }

    @Override
    public void showRegisterError(String message) {

    }

    @Override
    public void showSignUpSuccess() {

    }
}
