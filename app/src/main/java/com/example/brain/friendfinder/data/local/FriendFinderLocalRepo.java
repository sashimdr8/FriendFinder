package com.example.brain.friendfinder.data.local;

import com.android.annotations.NonNull;
import com.example.brain.friendfinder.data.model.Auth;

import javax.inject.Singleton;

/**
 * Created by brain on 1/12/17.
 */
@Singleton
public class FriendFinderLocalRepo {
    public FriendFinderLocalRepo(FriendFinderPref prefs) {
    }

    public void cacheAuthData(@NonNull Auth auth) {
    }
}
