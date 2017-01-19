package com.example.brain.friendfinder.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.example.brain.friendfinder.data.model.User;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

/**
 * Created by brain on 1/12/17.
 */

public class FriendFinderPref {
    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_USER = "_user";
    private static final String KEY_SETTINGS_SAVE_TIME = "_settings_save_time";

    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public FriendFinderPref(Context context, Gson gson) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.gson = gson;
    }

    void setUserId(String userId) {
        sharedPreferences.edit().putString(KEY_USER_ID, userId).apply();
    }

    String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, null);
    }

    void setUser(User user) {
        sharedPreferences.edit()
                .putString(KEY_USER, gson.toJson(user)).apply();
    }

    public User getUser() {
        String settingsString = sharedPreferences.getString(KEY_USER, null);
        if (!TextUtils.isEmpty(settingsString)) {
           User user = gson.fromJson(settingsString, User.class);
            if (user != null) {
                return user;
            }
        }
        return new User();
    }

}