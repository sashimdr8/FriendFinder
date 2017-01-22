package com.example.brain.friendfinder.main;



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
    public void stop() {

    }

    @Override
    public void start() {

    }
}
