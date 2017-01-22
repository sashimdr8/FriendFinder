package com.example.brain.friendfinder.main.home;

import com.example.brain.friendfinder.FriendFinderModule;

/**
 * Created by sashi on 1/22/2017.
 */

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View view;
    public HomePresenter(FriendFinderModule module, HomeContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
