package com.example.brain.friendfinder.auth.register;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;
import com.example.brain.friendfinder.data.model.Auth;
import com.example.brain.friendfinder.data.model.AuthResponse;

import okhttp3.ResponseBody;

/**
 * Created by brain on 1/12/17.
 */

public interface RegisterContract {

    interface Presenter extends BasePresenter{

        void signUp(String username, String password);

        void setAuthStateListener();
        void  onStop();
    }

    interface  View extends BaseView<Presenter>{

        void showSignUpError(String message);

        void showSignUpSuccess(String email);

        void showSignUpProgress();

    }
}
