package com.designskill.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.designskill.telemedicine.R;
import com.designskill.telemedicine.adapter.ChatMessageListAdapter;
import com.designskill.telemedicine.model.ChatMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    ChatMessageListAdapter chatMessageListAdapter;
    private RecyclerView chatRecyCleVeiw;
    ArrayList<ChatMessage> chatMessageArrayList;

    ImageView send;
    EditText edtxtmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initilize view
        init();

        chatMessageArrayList = new ArrayList<>();

        // chat view setup and adapter
        chatMessageListAdapter = new ChatMessageListAdapter(this, chatMessageArrayList);
        chatRecyCleVeiw.setLayoutManager(new LinearLayoutManager(this));
        chatRecyCleVeiw.setAdapter(chatMessageListAdapter);


// load data from json file
        loadChatlistintoListView();


    }

    private void init() {

        // tool bar setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = toolbar.findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edtxtmessage.getText().toString();

                if (message.equals("") || message.length() == 0) {
                    Toast.makeText(ChatActivity.this, "Please write message", Toast.LENGTH_SHORT).show();
                } else {
                    sendChat(message);
                }
            }
        });
        edtxtmessage = findViewById(R.id.edtxtmessage);
        chatRecyCleVeiw = (RecyclerView) findViewById(R.id.chatRecyCleVeiw);



    }

    // add chat in recycleview
    private void sendChat(String message) {

        try {
            ChatMessage doctor = new ChatMessage();
            doctor.setMessage(message);
            doctor.setTime("14.20");
            doctor.setType("sent");
            chatMessageArrayList.add(doctor);
            chatMessageListAdapter.setData(chatMessageArrayList);
            chatMessageListAdapter.notifyDataSetChanged();

            edtxtmessage.setText("");

        } catch (Exception e) {

        }
    }


    public void loadChatlistintoListView() {
        chatMessageArrayList = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                ChatMessage doctor = new ChatMessage();
                doctor.setMessage(jo_inside.getString("message"));
                doctor.setTime(jo_inside.getString("time"));
                doctor.setType(jo_inside.getString("type"));


                chatMessageArrayList.add(doctor);
            }


            chatMessageListAdapter.setData(chatMessageArrayList);
            chatMessageListAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // load json file from asset
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = ChatActivity.this.getAssets().open("chat.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
