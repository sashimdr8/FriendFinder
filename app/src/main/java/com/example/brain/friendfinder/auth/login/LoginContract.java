package com.example.brain.friendfinder.auth.login;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;

/**
 * Created by brain on 1/19/17.
 */

public interface LoginContract {

    interface Presenter extends BasePresenter{

        void login(String username, String password);
    }

    interface View extends BaseView<Presenter>{

        void showLoginSuccess(String email);

        void showLoginError(String error);
    }
}
