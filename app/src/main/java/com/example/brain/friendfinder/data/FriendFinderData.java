package com.example.brain.friendfinder.data;

import com.example.brain.friendfinder.data.local.FriendFinderLocalRepo;
import com.example.brain.friendfinder.data.model.AuthResponse;
import com.example.brain.friendfinder.data.remote.FriendFinderRemoteRepo;


import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by brain on 1/12/17.
 */
public class FriendFinderData {
    private FriendFinderLocalRepo localRepo;
    private FriendFinderRemoteRepo remoteRepo;

    public FriendFinderData(FriendFinderLocalRepo localRepo, FriendFinderRemoteRepo remoteRepo) {
        this.remoteRepo = remoteRepo;
        this.localRepo = localRepo;
    }


    public Single<AuthResponse> signUp(String username, String password) {

        return remoteRepo.signUp(username, password)
                .doOnSuccess(new Action1<AuthResponse>() {
                    @Override
                    public void call(AuthResponse auth) {
                      //  localRepo.cacheAuthData(auth);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
