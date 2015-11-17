package ru.ifmo.android_2015.servicedemo.broadcast;

import android.content.Intent;
import ru.ifmo.android_2015.servicedemo.MainActivity;
import ru.ifmo.android_2015.servicedemo.service.SimpleThreadService;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public class BroadcastService extends SimpleThreadService {
    public static final String EXTRA_STEP = "step";

    @Override
    protected void doStep(int n) {
        super.doStep(n);

        Intent intent = new Intent(SimpleReceiver.ACTION);
        intent.putExtra(EXTRA_STEP, n);
        sendBroadcast(intent);

        if (n == 20) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
