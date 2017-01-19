package com.example.brain.friendfinder.auth.register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.brain.friendfinder.FriendFinderApp;
import com.example.brain.friendfinder.FriendFinderModule;
import com.example.brain.friendfinder.data.model.Auth;
import com.example.brain.friendfinder.data.model.AuthResponse;
import com.example.brain.friendfinder.data.model.User;
import com.example.brain.friendfinder.data.remote.Api;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import okhttp3.ResponseBody;
import rx.Scheduler;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by brain on 1/12/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    FriendFinderModule module;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;


    public RegisterPresenter(FriendFinderModule module, RegisterContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.module = module;
        mAuth = FirebaseAuth.getInstance();


    }


    public void signUp(String username, String password) {
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            String email = firebaseUser.getEmail();
                          /*  User user= new User(firebaseUser.getUid(),firebaseUser.getEmail(),firebaseUser.getDisplayName()
                            );
                            module.provideData().cacheAuthResult(user);*/
                            view.showSignUpSuccess(email);
                        } else {
                            view.showSignUpError(String.valueOf(task.getException()));
                        }
                    }
                });

    }

    @Override
    public void setAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("mero", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("mero", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onStop() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /*  @Override
      public void signUp(String username, String password) {
          module.provideData().signUp(username, password)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Action1<AuthResponse>() {
                                 @Override
                                 public void call(AuthResponse auth) {
                                     view.showSignUpSuccess(auth);
                                 }
                             }
                          , new Action1<Throwable>() {
                              @Override
                              public void call(Throwable throwable) {
                                  view.showRegisterError(throwable.getMessage());
                              }
                          });

      }
  */
    @Override
    public void start() {
        mAuth.addAuthStateListener(mAuthListener);
    }
}
