package com.example.brain.friendfinder.utils;

import android.text.TextUtils;

/**
 * Created by brain on 1/16/17.
 */

public class Validator {
    public static final int MIN_LENGTH_PASSWORD = 4;
    public static final int MAX_LENGTH_PASSWORD = 50;

    public static boolean isValidPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return false;
        } else {
            return !TextUtils.isEmpty(password)
                    && password.length() >= MIN_LENGTH_PASSWORD
                    && password.length() <= MAX_LENGTH_PASSWORD;
        }
    }
}
