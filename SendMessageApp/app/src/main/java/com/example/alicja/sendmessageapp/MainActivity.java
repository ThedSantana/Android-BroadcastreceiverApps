package com.example.alicja.sendmessageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText messageToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageToSend = (EditText) findViewById(R.id.editText);
    }


    public void sendMessage(View view) {
        Intent messageIntent = new Intent();
        messageIntent.setAction("com.example.alicja.sendmessageapp.MESSAGE_INTENT");

        String messageText = messageToSend.getText().toString();
        messageIntent.putExtra("messageText", messageText);

        String permission = Manifest.permission.MY_PERMISSION;
        sendBroadcast(messageIntent, permission);

    }
}
