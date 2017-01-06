package com.example.brain.friendfinder.network;

import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by brain on 1/5/17.
 */

public interface Api {

    @POST("searchFriends/")
    Call<SearchFriendsModel> searchFriends(@Field("address") String address ,@Field("gender") String gender);

}
