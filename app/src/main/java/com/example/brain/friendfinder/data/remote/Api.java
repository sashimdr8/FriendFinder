package com.example.brain.friendfinder.data.remote;

import com.example.brain.friendfinder.data.model.Auth;
import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Single;

/**
 * Created by brain on 1/12/17.
 */

public interface Api {
    @POST("searchFriends/")
    Call<SearchFriendsModel> searchFriends(@Field("address") String address , @Field("gender") String gender);

    @POST("register/")
    Single<ResponseBody> signUp(@Field("username")String username , @Field("password") String password);
}
