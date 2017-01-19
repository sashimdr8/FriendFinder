package com.example.brain.friendfinder.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.auth.register.RegisterActivity;
import com.example.brain.friendfinder.databinding.ActivityMainBinding;
import com.example.brain.friendfinder.searchfriends.SearchFriendsActivity;
import com.example.brain.friendfinder.utils.Constants;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private ActivityMainBinding binding;
    private MainContract.Presenter presenter;
    String selectedAddress, selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        new MainPresenter(this);
        binding.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAddress = binding.spAddress.getSelectedItem().toString();
                selectedGender = binding.spGender.getSelectedItem().toString();
                presenter.startSearchFriends(selectedAddress, selectedGender);
            }
        });
        binding.btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }

    @Override
    public void startSearchFriendsActivity(String address, String gender) {
        Intent i = new Intent(this, SearchFriendsActivity.class);
        i.putExtra(Constants.ADDRESS, address);
        i.putExtra(Constants.GENDER, gender);
        startActivity(i);
    }
}
