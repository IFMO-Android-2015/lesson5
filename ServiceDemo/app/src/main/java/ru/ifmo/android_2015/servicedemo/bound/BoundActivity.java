package ru.ifmo.android_2015.servicedemo.bound;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import ru.ifmo.android_2015.servicedemo.R;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class BoundActivity extends Activity {
    private BoundService service;
    private boolean bound;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            /* IPC will fail here */
            BoundService.LocalBinder binder = (BoundService.LocalBinder) service;
            BoundActivity.this.service = binder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        setContentView(R.layout.activity_bound);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bound) {
            unbindService(connection);
            bound = false;
        }
    }

    public void actionClicked(View view) {
        if (!bound) {
            return;
        }

        TextView a = (TextView)findViewById(R.id.a);
        TextView b = (TextView)findViewById(R.id.b);
        TextView result = (TextView)findViewById(R.id.result);

        try {
            result.setText(String.valueOf(service.awesome(
                    Integer.parseInt(a.getText().toString()),
                    Integer.parseInt(b.getText().toString()))));
        } catch (Exception e) {

        }
    }
}
