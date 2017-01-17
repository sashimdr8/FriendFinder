package com.example.brain.friendfinder.auth.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.data.model.AuthResponse;
import com.example.brain.friendfinder.databinding.ActivityRegisterBinding;
import com.example.brain.friendfinder.utils.Utils;
import com.example.brain.friendfinder.utils.Validator;

import okhttp3.ResponseBody;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private RegisterContract.Presenter presenter;
    private ActivityRegisterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        new RegisterPresenter(FriendFinderApp.component(RegisterActivity.this), this);
        binding.btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUserName.getText().toString();
                String password = binding.etPassword.getText().toString();
                String confirmPassword = binding.etConfirmPassword.getText().toString();
                if (Validator.isValidPassword(password, confirmPassword) && !TextUtils.isEmpty(username))
                    presenter.signUp(username, password);
                else if (!Validator.isValidPassword(password,confirmPassword))
                    binding.etPassword.setError(getString(R.string.invalid_password));
                else  if(TextUtils.isEmpty(username))
                    binding.etUserName.setError(getString(R.string.invalid_username));

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
        Utils.showToast(this, message);

    }

    @Override
    public void showSignUpSuccess(AuthResponse authResponse) {

        Utils.showToast(this, authResponse.getToken());

    }
}
