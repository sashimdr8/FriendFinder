package com.example.brain.friendfinder.utils;

import com.jakewharton.rxrelay.PublishRelay;
import com.jakewharton.rxrelay.Relay;

/**
 * Created by brain on 1/13/17.
 */

public class RxBus {
    private final Relay<Object, Object> bus;

    public RxBus() {
        this.bus = PublishRelay.create().toSerialized();
    }

    public void post(Object o) {
        bus.call(o);
    }
}
