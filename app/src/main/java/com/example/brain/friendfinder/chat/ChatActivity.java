package com.example.brain.friendfinder.chat;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.data.model.User;
import com.example.brain.friendfinder.databinding.ActivityChatBinding;
import com.example.brain.friendfinder.utils.Utils;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by brain on 1/19/17.
 */

public class ChatActivity extends AppCompatActivity implements ChatContract.View {

    private ActivityChatBinding binding;
    private ChatContract.Presenter presenter;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        new ChatPresenter(FriendFinderApp.component(this),this);
        this.presenter.getInstance();
        binding.rvMessages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new ChatAdapter();
        binding.rvMessages.setAdapter(adapter);
        binding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendMessage(binding.etMessage.getText().toString());
                Utils.hideKeyPad(binding.getRoot());
            }
        });


    }

    @Override
    public void setPresenter(ChatContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public boolean consumeBackPress() {
        return false;
    }

    @Override
    public void showMessage(String value) {
        adapter.addMessage(value);
        binding.rvMessages.smoothScrollToPosition(adapter.getItemCount() - 1);

    }
}
