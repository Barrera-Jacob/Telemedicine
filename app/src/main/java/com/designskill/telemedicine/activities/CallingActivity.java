package com.designskill.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.designskill.telemedicine.R;

public class CallingActivity extends AppCompatActivity {


    ImageView imgEndCall,imgSound,imgVideo,imgChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);


        // Initiliaze view
        init();




    }
    // Initiliaze view
    private void init() {

        imgEndCall = findViewById(R.id.imgEndCall);
        imgEndCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgSound = findViewById(R.id.imgSound);
        imgSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgVideo = findViewById(R.id.imgVideo);
        imgVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgChat = findViewById(R.id.imgChat);
        imgChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
