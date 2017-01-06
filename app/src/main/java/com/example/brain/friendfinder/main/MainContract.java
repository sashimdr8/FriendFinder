package com.example.brain.friendfinder.main;

import android.content.Context;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;

/**
 * Created by brain on 1/6/17.
 */

public interface MainContract {
     interface Presenter extends BasePresenter {
        void startSearchFriends(String address, String gender);

        void stop();

    }

     interface View extends BaseView<Presenter> {

        void startSearchFriendsActivity(String address, String gender);

    }
}
