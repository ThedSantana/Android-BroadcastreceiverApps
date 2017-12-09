package com.example.alicja.receivemessageapp;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class ServiceBroadcast extends Service {

    private static final String TAG = "ServiceBroadcast";
    MyBroadcastReceiver receiver = new MyBroadcastReceiver();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.alicja.sendmessageapp.MESSAGE_INTENT");

        registerReceiver(receiver, filter, "com.example.alicja.sendmessageapp.my_permissions.MY_PERMISSION", null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.i(TAG, "onDestroy: destroy ");

    }

}
