package com.example.brain.friendfinder.main.home;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brain.friendfinder.BaseFragment;
import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.auth.login.LoginActivity;
import com.example.brain.friendfinder.auth.register.RegisterActivity;
import com.example.brain.friendfinder.chat.ChatActivity;
import com.example.brain.friendfinder.databinding.FragmentHomeBinding;
import com.example.brain.friendfinder.main.MainActivity;
import com.example.brain.friendfinder.searchfriends.SearchFriendsActivity;
import com.example.brain.friendfinder.utils.Constants;

/**
 * Created by sashi on 1/22/2017.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    HomeContract.Presenter presenter;
    private FragmentHomeBinding binding;
    String selectedAddress, selectedGender;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        new HomePresenter(FriendFinderApp.component(getActivity()),this);
        binding.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAddress = binding.spAddress.getSelectedItem().toString();
                selectedGender = binding.spGender.getSelectedItem().toString();
                Intent i = new Intent(getActivity(), SearchFriendsActivity.class);
                i.putExtra(Constants.ADDRESS, selectedAddress);
                i.putExtra(Constants.GENDER, selectedGender);
                startActivity(i);
            }
        });
        binding.btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });
        binding.btChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ChatActivity.class));
            }
        });
        binding.btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return binding.getRoot();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }
}
