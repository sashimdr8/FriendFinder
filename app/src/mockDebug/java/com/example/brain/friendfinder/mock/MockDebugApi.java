package com.example.brain.friendfinder.mock;

import android.content.Context;
import android.widget.Toast;

import com.example.brain.friendfinder.network.Api;
import com.example.brain.friendfinder.searchfriends.SearchFriendsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by brain on 1/5/17.
 */

public class MockDebugApi implements Api{
    private Context context;
    ArrayList<SearchFriendsModel.DataBean> friends;
    SearchFriendsModel searchFriendsModel;

    public MockDebugApi(Context context) {
        this.context = context;
    }

    public ArrayList<SearchFriendsModel.DataBean> searchFriends(String address, String gender) {
        friends = new ArrayList<>();

        try {
            String successfulResponse = Utils.
                    getStringFromFile(context, "nearByFriends.json");
            Gson gson = new GsonBuilder().create();
            searchFriendsModel = gson.fromJson(successfulResponse, SearchFriendsModel.class);
            String responseCode = searchFriendsModel.getMessage();
            if (responseCode.equalsIgnoreCase("Success")) {

                for (int i = 0; i < searchFriendsModel.getData().size(); i++) {


                    filterFriends(i, address, gender, searchFriendsModel.getData().get(i).getAddress(),
                            searchFriendsModel.getData().get(i).getGender());

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

    private void filterFriends(int position,
                               String selectedAddress, String selectedGender,
                               String address, String gender) {

        if (selectedAddress.equalsIgnoreCase("Any City")) {
            if (selectedGender.equalsIgnoreCase("Any Gender")) {
                friends.add(searchFriendsModel.getData().get(position));
            } else {
                if (selectedGender.equalsIgnoreCase(gender)) {
                    friends.add(searchFriendsModel.getData().get(position));
                }
            }
        } else {
            if (selectedAddress.equalsIgnoreCase(address)) {
                if (selectedGender.equalsIgnoreCase("Any Gender")) {
                    friends.add(searchFriendsModel.getData().get(position));
                } else {
                    if (selectedGender.equalsIgnoreCase(gender)) {
                        friends.add(searchFriendsModel.getData().get(position));
                    }
                }
            }
        }

    }

}
