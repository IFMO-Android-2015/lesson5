package ru.ifmo.android_2015.servicedemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class ConnectivityReceiver extends BroadcastReceiver {
    private static final String TAG = ConnectivityReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());
    }
}
