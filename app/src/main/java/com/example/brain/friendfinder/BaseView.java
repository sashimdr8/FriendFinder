package com.example.brain.friendfinder;

/**
 * Created by brain on 1/5/17.
 */

public interface BaseView<T extends BasePresenter> {


    void setPresenter(T presenter);

    boolean consumeBackPress();
}
