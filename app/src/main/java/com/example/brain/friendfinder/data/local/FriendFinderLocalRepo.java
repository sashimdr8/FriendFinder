package com.example.brain.friendfinder.data.local;

import com.example.brain.friendfinder.data.model.User;


/**
 * Created by brain on 1/12/17.
 */

public class FriendFinderLocalRepo {
    private FriendFinderPref prefs;
    public FriendFinderLocalRepo(FriendFinderPref prefs) {
        this.prefs= prefs;
    }

    public void cacheAuthData(User user) {
        prefs.setUserId(user.getUserId());
        prefs.setUser(user);
    }

    public User getUser() {
        return prefs.getUser();
    }
}
