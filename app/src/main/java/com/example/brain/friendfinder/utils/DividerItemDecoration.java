package com.example.brain.friendfinder.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by brain on 1/5/17.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration{
    private int mItemOffset;

    public DividerItemDecoration(int itemOffset) {
        mItemOffset = itemOffset;
    }

    public DividerItemDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, mItemOffset, 0, 0);
    }
}
