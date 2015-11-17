package ru.ifmo.android_2015.servicedemo.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import ru.ifmo.android_2015.servicedemo.R;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public class SimpleThreadService extends Service implements Runnable {
    private static final String TAG = SimpleThreadService.class.getSimpleName();
    int n;
    private Thread thread;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        if (intent != null) {
            boolean foreground = intent.getBooleanExtra(ServiceThreadActivity.IS_FOREGROUND, false);
            if (foreground) {
                startForeground(1, new Notification.Builder(this).
                        setContentTitle("Hello!").
                        setSmallIcon(R.mipmap.ic_launcher).build());
            }
            else {
                stopForeground(true);
            }
        }

        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (thread != null) {
            thread.interrupt();
            thread = null;
        }

        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Log.d(TAG, "Do step " + n);
                doStep(n++);
                if (n > 1000) {
                    Log.d(TAG, "Call stopSelf");
                    stopSelf();
                    break;
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }

    protected void doStep(int n) {
        Log.d(TAG, "Step: " + n);
    }
}
