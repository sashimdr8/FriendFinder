package com.example.brain.friendfinder.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivityMainBinding;
import com.example.brain.friendfinder.searchfriends.SearchFriendsActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SearchFriendsActivity.class);
                startActivity(i);
            }
        });


    }
}
