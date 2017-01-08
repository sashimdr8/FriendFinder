package com.example.brain.friendfinder.searchfriends;

import android.content.Context;


import com.example.brain.friendfinder.mock.MockDebugApi;

import java.util.ArrayList;

/**
 * Created by brain on 1/5/17.
 */

public class SearchFriendsPresenter implements SearchFriendsContract.Presenter {
    Context context;
    MockDebugApi api;
    private SearchFriendsContract.View view;
    private ArrayList<SearchFriendsModel.DataBean> friends;


    public SearchFriendsPresenter(Context context, SearchFriendsContract.View view) {
        this.context = context;
        this.api = new MockDebugApi(context);
        this.view = view;
    }



    @Override
    public void start() {

    }

    @Override
    public void searchFriends(String address, String gender) {
        friends= api.searchFriends(address,gender);
        view.showFriendListResult(friends);

    }

    @Override
    public void stop() {
        if(!friends.isEmpty()){
            friends.clear();
        }
    }
}
