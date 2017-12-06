package com.example.alicja.receivemessageapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {


    private static final String TAG = "MyBroadcastReceiver";
    private static final String NOTIFICATION_TITLE = "New message received!";

    private static final int MESSAGE_NOTIFICATION_ID = 8285;
    private static final int MESSAGE_PENDING_INTENT_ID = 4893;

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getExtras().getString("messageText");
        PendingIntent contentIntent = PendingIntent.getActivity(context, MESSAGE_PENDING_INTENT_ID,
                new Intent(context, MainActivity.class), 0);


        Notification.Builder mBuilder =
                new Notification.Builder(context)
                        .setSmallIcon(R.drawable.ic_chat_bubble_outline_black_24dp)
                        .setContentTitle(NOTIFICATION_TITLE)
                        .setContentText(message);
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID, mBuilder.build());

        Log.i(TAG, "onReceive: message received");
    }
}
