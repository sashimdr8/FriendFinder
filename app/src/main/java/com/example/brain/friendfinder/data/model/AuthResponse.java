package com.example.brain.friendfinder.data.model;

/**
 * Created by brain on 1/16/17.
 */

public class AuthResponse {

    /**
     * code : 200
     * message : Sign Up Failed
     * token :
     */

    private int code;
    private String message;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
