package ru.ifmo.android_2015.servicedemo.service;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class ThreadActivity extends Activity {
    private static final String TAG = ThreadActivity.class.getSimpleName();
    private static Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (thread == null) {
            thread = new Thread(new SimpleRunnable());
            thread.start();
        }
    }

    private static class SimpleRunnable implements Runnable {
        int n;

        @Override
        public void run() {
            try {
                while (true) {
                    Log.d(TAG, "Step: " + n++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
