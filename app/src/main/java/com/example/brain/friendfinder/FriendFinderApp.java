package com.example.brain.friendfinder;

import android.app.Application;
import android.content.Context;


/**
 * Created by brain on 1/12/17.
 */

public class FriendFinderApp extends Application {
    FriendFinderModule module;




    @Override
    public void onCreate() {
        super.onCreate();
        this.module = new FriendFinderModule(this.getApplicationContext());


    }

    public static FriendFinderModule component(Context context) {
        return ((FriendFinderApp) context.getApplicationContext()).module;
    }


}
