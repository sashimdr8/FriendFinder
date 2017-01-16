package com.example.brain.friendfinder.auth.register;

import android.content.Context;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.data.model.Auth;
import com.example.brain.friendfinder.data.model.AuthResponse;
import com.example.brain.friendfinder.data.remote.Api;

import okhttp3.ResponseBody;
import rx.Scheduler;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    FriendFinderModule module;

    public RegisterPresenter(FriendFinderModule module, RegisterContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.module = module;

    }


    @Override
    public void signUp(String username, String password) {
        module.provideData().signUp(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AuthResponse>() {
                               @Override
                               public void call(AuthResponse auth) {
                                   view.showSignUpSuccess(auth);
                               }
                           }
                        , new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                view.showRegisterError(throwable.getMessage());
                            }
                        });

    }

    @Override
    public void start() {

    }
}
