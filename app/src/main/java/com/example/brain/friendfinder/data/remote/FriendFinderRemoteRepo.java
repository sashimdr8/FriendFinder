package com.example.brain.friendfinder.data.remote;

import com.example.brain.friendfinder.data.model.Auth;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import rx.Single;

/**
 * Created by brain on 1/12/17.
 */

public class FriendFinderRemoteRepo {
    private Api api;
    private Gson gson;

    public FriendFinderRemoteRepo(Api api, Gson gson) {
        this.api = api;
        this.gson = gson;

    }

    public Single<ResponseBody> signUp(String username, String password) {
        return api.signUp(username,password);
    }
}
