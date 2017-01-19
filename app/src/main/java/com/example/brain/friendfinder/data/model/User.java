package com.example.brain.friendfinder.data.model;

/**
 * Created by brain on 1/19/17.
 */

public class User {
    private String userId;
    private String email;
    private  String userName;
    private  String userPhoto;

    public User() {
    }

    public User(String userId, String email, String userName) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }


}
