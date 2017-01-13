package com.example.brain.friendfinder.auth.register;

import android.content.Context;

import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.data.model.Auth;
import com.example.brain.friendfinder.data.remote.Api;

import okhttp3.ResponseBody;
import rx.Single;
import rx.functions.Action1;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    FriendFinderModule module;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.module = new FriendFinderModule();
       // this.module = new FriendFinderModule(context);

    }


    @Override
    public void signUp(String username, String password) {
        Api api = module.provideRetrofit().create(Api.class);
        api.signUp(username, password)
                .subscribe(new Action1<ResponseBody>() {
                               @Override
                               public void call(ResponseBody auth) {
                                   view.showSignUpSuccess();
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
