package ru.ifmo.android_2015.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ru.ifmo.android_2015.servicedemo.bound.BoundActivity;
import ru.ifmo.android_2015.servicedemo.broadcast.BroadcastActivity;
import ru.ifmo.android_2015.servicedemo.service.ServiceThreadActivity;
import ru.ifmo.android_2015.servicedemo.service.ThreadActivity;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void threadClicked(View view) {
        startActivity(new Intent(this, ThreadActivity.class));
    }

    public void threadServiceClicked(View view) {
        startActivity(new Intent(this, ServiceThreadActivity.class));
    }

    public void foregroundServiceClicked(View view) {
        final Intent intent = new Intent(this, ServiceThreadActivity.class);
        intent.putExtra(ServiceThreadActivity.IS_FOREGROUND, true);
        startActivity(intent);
    }

    public void broadcastClicked(View view) {
        startActivity(new Intent(this, BroadcastActivity.class));
    }

    public void boundClicked(View view) {
        startActivity(new Intent(this, BoundActivity.class));
    }
}
