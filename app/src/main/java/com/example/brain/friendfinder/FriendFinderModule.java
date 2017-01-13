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
    FriendFinderPref prefs;

    //private final Context app;

    private   Api api;

    public  Api api(){
        return api;
    }

   /* public FriendFinderModule(Context app) {
        this.app = app;
        this.prefs = new FriendFinderPref(app,gson());
        this.localRepo = new FriendFinderLocalRepo(prefs);
        this.remoteRepo = new FriendFinderRemoteRepo(api,gson());
    }
*/
//    public Context provideContext() {
//        return app;
//    }

//    public FriendFinderData provideData() {
//        return new FriendFinderData(localRepo,remoteRepo);
//    }


    public RxBus provideBus() {
        return new RxBus();
    }


    public Gson gson() {
        return new Gson();
    }


  /*  public FriendFinderPref providePrefs(Gson gson) {
        return new FriendFinderPref(app, gson);
    }*/


    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())//To convert primitive and boxed types
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public FriendFinderLocalRepo provideLocalRepo(FriendFinderPref prefs) {
        return new FriendFinderLocalRepo(prefs);
    }


    public FriendFinderRemoteRepo provideRemoteRepo(Api api, Gson gson) {
        return new FriendFinderRemoteRepo(api, gson);
    }



}
