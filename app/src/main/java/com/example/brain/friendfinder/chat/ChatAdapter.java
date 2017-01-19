package com.example.brain.friendfinder.chat;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.brain.friendfinder.R;
import com.example.brain.friendfinder.data.model.MessageModel;
import com.example.brain.friendfinder.data.model.User;
import com.example.brain.friendfinder.databinding.ListItemChatMessagesBinding;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by brain on 1/19/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<MessageModel> messages;

    public ChatAdapter() {
        this.messages = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemChatMessagesBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_chat_messages, parent, false);
        return new ChatHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatHolder chatHolder = (ChatHolder) holder;
        chatHolder.binding.tvMessage.setText(messages.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return (messages!=null)? messages.size(): 0;
    }

    public void addMessage(String message){
        this.messages.add(new MessageModel(message));
        notifyDataSetChanged();
    }

    class ChatHolder extends RecyclerView.ViewHolder {
        public ListItemChatMessagesBinding binding;

        public ChatHolder(ListItemChatMessagesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
