package com.example.brain.friendfinder.utils;

import com.squareup.otto.Bus;

/**
 * Created by brain on 1/6/17.
 */

public class DataBus {
    public static Bus bus;

    public static Bus getInstance() {
        bus = new Bus();
        return bus;
    }
}
