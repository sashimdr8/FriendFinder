package com.example.brain.friendfinder.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.brain.friendfinder.chat.ChatContract;

/**
 * Created by brain on 1/13/17.
 */

public class Utils {

    public static void showToast(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void hideKeyPad(View view){
        InputMethodManager mgr = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
