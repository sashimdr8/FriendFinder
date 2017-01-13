package com.example.brain.friendfinder.auth.register;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;

/**
 * Created by brain on 1/12/17.
 */

public interface RegisterContract {

    interface Presenter extends BasePresenter{

        void signUp(String username, String password);
    }

    interface  View extends BaseView<Presenter>{

        void showRegisterError(String message);

        void showSignUpSuccess();
    }
}
