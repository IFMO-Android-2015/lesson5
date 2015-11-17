package ru.ifmo.android_2015.servicedemo.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by alexey.nikitin on 16.11.15.
 */
public final class ServiceThreadActivity extends Activity {
    public static final String IS_FOREGROUND = "is-foreground";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent service = new Intent(this, SimpleThreadService.class);
        service.putExtra(IS_FOREGROUND, getIntent().getBooleanExtra(IS_FOREGROUND, false));
        startService(service);
    }
}
