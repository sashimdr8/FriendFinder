package com.example.brain.friendfinder.mock;

import android.content.Context;

import com.example.brain.friendfinder.BaseResponse;
import com.example.brain.friendfinder.network.Api;
import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by brain on 1/5/17.
 */

public class NotUsed implements Api {
    private final Context context;
    private final BehaviorDelegate<Api> delegate;
    private final Gson gson;
    private final Retrofit retrofit;

    public NotUsed(Context context, Retrofit retrofit) {
        this.context = context;
        this.gson = new Gson();
        this.retrofit = retrofit;
        NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setDelay(500, TimeUnit.MILLISECONDS);
        networkBehavior.setFailurePercent(2);
        networkBehavior.setVariancePercent(40);
        this.delegate = new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior)
                .build().create(Api.class);
    }

    @Override
    public Call<SearchFriendsModel> searchFriends
            (@Field("address") String address, @Field("gender") String gender) {
        try {
            String successfulResponse = Utils.
                    getStringFromFile(context, "nearByFriends.json");
            Type settingsType = new TypeToken<BaseResponse<SearchFriendsModel>>() {
            }.getType();
            BaseResponse<SearchFriendsModel> baseResponse = gson.fromJson(successfulResponse, settingsType);
            return delegate.returning(Calls.response(baseResponse.getData()))
                    .searchFriends(address, gender);
        } catch (Exception e) {
            e.printStackTrace();
            return delegate.returning(Calls.failure(new IOException(e)))
                    .searchFriends(address, gender);
        }
    }
}
