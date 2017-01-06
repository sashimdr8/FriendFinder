package com.example.brain.friendfinder.main;

import android.content.Context;
import android.content.Intent;

import com.example.brain.friendfinder.searchfriends.SearchFriendsActivity;
import com.example.brain.friendfinder.utils.Constants;
import com.example.brain.friendfinder.utils.DataBus;
import com.squareup.otto.Bus;

/**
 * Created by brain on 1/6/17.
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;

    MainPresenter(MainContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }


    @Override
    public void startSearchFriends(String address, String gender) {
        view.startSearchFriendsActivity(address,gender);

    }

    @Override
    public void stop() {

    }

    @Override
    public void start() {

    }
}
