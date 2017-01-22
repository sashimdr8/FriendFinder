package com.example.brain.friendfinder.auth.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivityLoginBinding;
import com.example.brain.friendfinder.main.MainActivity;
import com.example.brain.friendfinder.utils.Utils;

/**
 * Created by brain on 1/19/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    LoginContract.Presenter presenter;
    ActivityLoginBinding binding;
    ProgressDialog dialog;
    FriendFinderModule module;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        module = FriendFinderApp.component(LoginActivity.this);
        new LoginPresenter(this, module, this);
        if(!TextUtils.isEmpty(module.provideData().getuser().getUserId())){
            startActivity(new Intent(this,MainActivity.class));
        }
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUserName.getText().toString();
                String password = binding.etPassword.getText().toString();
                presenter.login(username, password);
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
        startActivity(new Intent(this, MainActivity.class));
        Utils.showToast(this, "Login Successful \n Welcome " + email);
        dialog.dismiss();
    }

    @Override
    public void showLoginError(String error) {
        Utils.showToast(this, error);
        dialog.dismiss();

    }

    @Override
    public void showLoginProgress() {
        dialog = new ProgressDialog(LoginActivity.this);
        dialog.setTitle("Signing In");
        dialog.setMessage("Please wait till the process completes..");
        dialog.show();

    }
}
