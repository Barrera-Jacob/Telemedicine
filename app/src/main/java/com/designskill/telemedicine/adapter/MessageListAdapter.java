package com.designskill.telemedicine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.designskill.telemedicine.R;
import com.designskill.telemedicine.model.Message;

import java.util.ArrayList;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MyViewHolder> {

    private ArrayList<Message> messageArrayList;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, message, time;

        public MyViewHolder(View view) {
            super(view);

            // initialize view
            name = (TextView) view.findViewById(R.id.name);
            message = (TextView) view.findViewById(R.id.message);
            time = (TextView) view.findViewById(R.id.time);

        }
    }


    public MessageListAdapter(ArrayList<Message> messageArrayList, Context context, onSelectedPlaceListener m_onSelectedPlaceListener) {
        this.messageArrayList = messageArrayList;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;
    }

    @Override
    public MessageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_message_list_row, parent, false);


        return new MessageListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MessageListAdapter.MyViewHolder holder, int position) {
        final Message place = messageArrayList.get(position);

        try {

// showing data to view
            holder.name.setText(place.getName());
            holder.message.setText(place.getMessage());
            holder.time.setText(place.getTime());

        } catch (Exception e) {

        }
    }

    public void setData(ArrayList<Message> lst) {
        this.messageArrayList = lst;
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }


    public static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public interface onSelectedPlaceListener {
        void onClick(Message place);
    }


    public ArrayList<Message> getAllData() {
        return messageArrayList;
    }
}