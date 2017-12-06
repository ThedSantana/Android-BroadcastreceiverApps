package com.example.alicja.receivemessageapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.alicja.receivemessageapp.utilities.NotificationUtils;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: getting message");
        String message = intent.getExtras().getString("messageText");

        Log.i(TAG, "onReceive: passing message to notificationUtils");
        NotificationUtils.showMessageNotification(context, message);

    }
}
