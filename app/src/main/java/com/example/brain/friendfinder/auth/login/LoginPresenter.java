package com.example.brain.friendfinder.auth.login;

import android.app.Activity;
import android.content.Context;


import com.android.annotations.NonNull;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by brain on 1/19/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;
    private FirebaseAuth auth;
    private FriendFinderModule module;
    Activity activity;


    public LoginPresenter(Activity activity, FriendFinderModule module, LoginContract.View view) {
        this.module = module;
        this.view = view;
        this.view.setPresenter(this);
        this.activity = activity;
    }

    @Override

    public void start() {

    }

    @Override
    public void login(String email, String password) {
        auth = FirebaseAuth.getInstance();
        view.showLoginProgress();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            String email = firebaseUser.getEmail();
                            User user = new User(firebaseUser.getUid(), firebaseUser.getEmail(), firebaseUser.getDisplayName()
                            );
                            module.provideData().cacheAuthResult(user);
                            view.showLoginSuccess(email);
                        } else {
                            view.showLoginError(String.valueOf(task.getException()));
                        }
                    }
                });

    }
}
