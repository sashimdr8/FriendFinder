package com.example.brain.friendfinder.searchfriends;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.databinding.ActivityMainBinding;
import com.example.brain.friendfinder.databinding.ListItemSearchFriendsBinding;

import java.util.ArrayList;

/**
 * Created by brain on 1/5/17.
 */

public class SearchFriendsAdapter extends RecyclerView.Adapter<SearchFriendsAdapter.MyViewHolder> {
    ArrayList<SearchFriendsModel.DataBean> friends;
    Context context;

    public SearchFriendsAdapter(Context context, ArrayList<SearchFriendsModel.DataBean> friends) {
        this.friends = friends;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemSearchFriendsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_search_friends, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      /*  Glide.with(context).load(friends.get(position).getImage())
                .thumbnail(0.5f)
                .crossFade()
                .into(holder.binding.imageView);*/
        if (friends.isEmpty() || friends == null) {
            holder.binding.tvName.setText("No any result");
        }
        holder.binding.tvAddress.setText("Address : " + friends.get(position).getAddress());
        holder.binding.tvGender.setText("Gender : " + friends.get(position).getGender());
        holder.binding.tvName.setText(friends.get(position).getName());
        holder.binding.tvInterestedIn.setText("Interested In : " + friends.get(position).getInterestedIn());

    }

    @Override
    public int getItemCount() {
        return (friends != null) ? friends.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ListItemSearchFriendsBinding binding;

        public MyViewHolder(ListItemSearchFriendsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
