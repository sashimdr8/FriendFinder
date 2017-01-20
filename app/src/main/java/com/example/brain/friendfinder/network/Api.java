package com.example.brain.friendfinder.network;

import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by brain on 1/5/17.
 */

public interface Api {

    ArrayList<SearchFriendsModel.DataBean> searchFriends(String address, String gender);


}
