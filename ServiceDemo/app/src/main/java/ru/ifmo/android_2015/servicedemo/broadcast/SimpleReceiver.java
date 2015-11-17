package ru.ifmo.android_2015.servicedemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class SimpleReceiver extends BroadcastReceiver {
    public static final String ACTION = "ru.ifmo.android_2015.SIMPLE_ACTION";

    private static final String TAG = SimpleReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());
    }
}
