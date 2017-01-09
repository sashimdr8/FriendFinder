package com.example.brain.friendfinder.utils;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.brain.friendfinder.R;

/**
 * Created by sashi on 1/8/2017.
 */

public class FriendsFinderBinding {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl))
            Glide.with(imageView.getContext()).load(imageUrl)
                    .into(imageView);
    }
}
