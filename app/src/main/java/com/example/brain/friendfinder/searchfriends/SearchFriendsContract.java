package com.example.brain.friendfinder.searchfriends;

import com.example.brain.friendfinder.BasePresenter;
import com.example.brain.friendfinder.BaseView;

import java.util.ArrayList;

/**
 * Created by brain on 1/5/17.
 */

public interface SearchFriendsContract {

    public interface  Presenter extends BasePresenter{
        void searchFriends(String address , String gender);
        void stop();

    }
     public interface View extends BaseView<Presenter>{
         void showFriendListResult(ArrayList<SearchFriendsModel.DataBean> friends);

         void showSearchFriendsProgress();

         void showSearchFriendsError();

         void showSearchFriendsSuccess();

     }
}
