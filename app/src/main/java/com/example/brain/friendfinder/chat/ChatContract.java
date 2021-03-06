package com.example.brain.friendfinder.chat;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;
import com.example.brain.friendfinder.data.model.User;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by brain on 1/19/17.
 */

public interface ChatContract {

    interface Presenter extends BasePresenter{

        void getInstance();
        void sendMessage(String message);
    }

    interface View extends BaseView<Presenter>{

        void showMessage(String value);
    }
}
