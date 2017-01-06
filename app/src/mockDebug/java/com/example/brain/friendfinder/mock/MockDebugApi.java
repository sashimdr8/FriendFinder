package com.example.brain.friendfinder.mock;

import android.content.Context;
import android.widget.Toast;

import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by brain on 1/5/17.
 */

public class MockDebugApi {
    private Context context;

    public MockDebugApi(Context context) {
        this.context = context;
    }

    public  ArrayList<SearchFriendsModel.DataBean> searchFriends(String address, String gender) {
         ArrayList<SearchFriendsModel.DataBean> friends = new ArrayList<>();

        try {
            String successfulResponse = Utils.
                    getStringFromFile(context, "nearByFriends.json");
            Gson gson = new GsonBuilder().create();
            SearchFriendsModel searchFriendsModel = gson.fromJson(successfulResponse, SearchFriendsModel.class);
            String responseCode = searchFriendsModel.getMessage();
            if (responseCode.equalsIgnoreCase("Success")) {
                for (int i = 0; i < searchFriendsModel.getData().size(); i++) {
                    friends.add(searchFriendsModel.getData().get(i));
                }
                return friends;
            } else if (responseCode.equalsIgnoreCase("INVALID_REQUEST")) {
                Toast.makeText(context, "invalid request", Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return friends;

    }
}
