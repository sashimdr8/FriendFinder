package com.example.brain.friendfinder.auth.register;

import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.data.model.Auth;

import rx.functions.Action1;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    FriendFinderModule module;

    public RegisterPresenter(FriendFinderModule module, RegisterContract.View view) {
        this.module = module;
        this.view = view;
        this.view.setPresenter(this);

    }


    @Override
    public void signUp(String username, String password) {
        module.provideData().signUp(username, password)
                .subscribe(new Action1<Auth>() {
                               @Override
                               public void call(Auth auth) {
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
