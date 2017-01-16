package com.example.brain.friendfinder;

import android.content.Context;

import com.example.brain.friendfinder.data.FriendFinderData;
import com.example.brain.friendfinder.data.local.FriendFinderLocalRepo;
import com.example.brain.friendfinder.data.local.FriendFinderPref;
import com.example.brain.friendfinder.data.remote.Api;
import com.example.brain.friendfinder.data.remote.FriendFinderRemoteRepo;
import com.example.brain.friendfinder.utils.Constants;
import com.example.brain.friendfinder.utils.RxBus;
import com.google.gson.Gson;
/*
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;*/
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by brain on 1/12/17.
 */
/*
@Module
*/
public final class FriendFinderModule {
    FriendFinderRemoteRepo remoteRepo;
    FriendFinderLocalRepo localRepo;
    private final Context app;

    public Api api() {
        return provideRetrofit().create(Api.class);
    }

    public FriendFinderModule(Context app) {
        this.app = app;
        this.localRepo = new FriendFinderLocalRepo(providePrefs(gson()));
        this.remoteRepo = new FriendFinderRemoteRepo(api(), gson());
    }

    public FriendFinderData provideData() {
        return new FriendFinderData(localRepo, remoteRepo);
    }


    public RxBus provideBus() {
        return new RxBus();
    }


    public Gson gson() {
        return new Gson();
    }


    public FriendFinderPref providePrefs(Gson gson) {
        return new FriendFinderPref(app, gson);
    }


    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())//To convert primitive and boxed types
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


}
