package com.example.brain.friendfinder.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by brain on 1/13/17.
 */

public class Utils {

    public static void showToast(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
