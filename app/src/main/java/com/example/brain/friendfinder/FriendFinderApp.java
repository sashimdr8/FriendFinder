package com.example.brain.friendfinder;

import android.app.Application;
import android.content.Context;


/**
 * Created by brain on 1/12/17.
 */

public class FriendFinderApp extends Application {



    public static FriendFinderModule component(Context context) {
        return  new FriendFinderModule(context);
    }


}
