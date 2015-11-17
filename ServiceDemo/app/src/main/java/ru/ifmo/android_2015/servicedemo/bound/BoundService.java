package ru.ifmo.android_2015.servicedemo.bound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class BoundService extends Service {
    private final LocalBinder binder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

    public int awesome(int a, int b) {
        return b != 0 ? a % b : 0;
    }
}
