package com.example.alicja.receivemessageapp.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.alicja.receivemessageapp.MainActivity;
import com.example.alicja.receivemessageapp.R;

public class NotificationUtils {

    private static final String TAG = "NotificationUtils";

    private static final String NOTIFICATION_TITLE = "New message received!";

    private static final int MESSAGE_NOTIFICATION_ID = 8285;
    private static final int MESSAGE_PENDING_INTENT_ID = 4893;

    public static void showMessageNotification(Context context, String message) {

        Log.i(TAG, "showMessageNotification: getting the notification manager");
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Log.i(TAG, "showMessageNotification: preparing notification");
        Notification.Builder notificationBuilder =
                new Notification.Builder(context)
                        .setSmallIcon(R.drawable.ic_chat_bubble_outline_black_24dp)
                        .setColor(ContextCompat.getColor(context, R.color.colorAccent))
                        .setContentTitle(NOTIFICATION_TITLE)
                        .setContentText(message)
                        .setContentIntent(getPendingIntent(context))
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setAutoCancel(true);


        Log.i(TAG, "showMessageNotification: showing notification");
        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID, notificationBuilder.build());
    }


    public static PendingIntent getPendingIntent(Context context) {

        //Intent opening the MainActivity:
        Intent mainActivityIntent = new Intent(context, MainActivity.class);

        return PendingIntent.getActivity(
                context,
                MESSAGE_PENDING_INTENT_ID,
                mainActivityIntent,
                0);
    }


}
