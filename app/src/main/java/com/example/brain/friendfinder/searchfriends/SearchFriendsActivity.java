package com.example.brain.friendfinder.searchfriends;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivitySearchFriendsBinding;
import com.example.brain.friendfinder.utils.Constants;
import com.example.brain.friendfinder.utils.DividerItemDecoration;

import java.util.ArrayList;


/**
 * Created by brain on 1/5/17.
 */

public class SearchFriendsActivity extends
        AppCompatActivity implements SearchFriendsContract.View {
    private SearchFriendsContract.Presenter presenter;
    private ActivitySearchFriendsBinding binding;
    private SearchFriendsAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_friends);
        getSupportActionBar().setTitle("Search Friends");
        String selectedAddress = getIntent().getStringExtra(Constants.ADDRESS);
        String selectedGender = getIntent().getStringExtra(Constants.GENDER);
        presenter = new SearchFriendsPresenter(this, this);
        presenter.searchFriends(selectedAddress, selectedGender);
    }

    @Override
    public void showFriendListResult(ArrayList<SearchFriendsModel.DataBean> friends) {
        adapter = new SearchFriendsAdapter(this, friends);
        binding.rvFriends.setAdapter(adapter);
        binding.rvFriends.addItemDecoration(new DividerItemDecoration(this, R.dimen.activity_horizontal_margin));
        binding.rvFriends.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    @Override
    public void showSearchFriendsProgress() {

    }

    @Override
    public void showSearchFriendsError() {

    }

    @Override
    public void showSearchFriendsSuccess() {

    }


    @Override
    public void setPresenter(SearchFriendsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }
}
