package com.example.brain.friendfinder.chat;

import android.util.Log;

import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.data.model.User;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by brain on 1/19/17.
 */

public class ChatPresenter implements ChatContract.Presenter {
    private ChatContract.View view;
    FriendFinderModule module;
    DatabaseReference myRef;

    public ChatPresenter(FriendFinderModule module,ChatContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.module = module;

    }

    @Override

    public void start() {

    }

    @Override
    public void getInstance() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                view.showMessage(value);
                Log.d("mero", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("mero", "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void sendMessage(String message) {
        User user = module.provideData().getuser();
        myRef.setValue(user.getEmail()+" : "+message);


    }
}
