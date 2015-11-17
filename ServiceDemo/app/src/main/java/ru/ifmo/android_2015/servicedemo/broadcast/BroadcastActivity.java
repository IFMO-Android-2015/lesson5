package ru.ifmo.android_2015.servicedemo.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class BroadcastActivity extends Activity {

    private TextView textView;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setTextSize(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics()));
        setContentView(textView);

        startService(new Intent(this, BroadcastService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (receiver == null) {
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    int n = intent.getIntExtra(BroadcastService.EXTRA_STEP, 0);
                    textView.setText("Step: " + n);
                }
            };

            IntentFilter intentFilter = new IntentFilter(SimpleReceiver.ACTION);
            registerReceiver(receiver, intentFilter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }
}
