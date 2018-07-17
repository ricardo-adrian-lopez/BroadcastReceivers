package com.mobileapps.training.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class        MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String ACTION_OUTSIDE = "actionOut";
    public static final String MY_KEY ="myKey" ;
    MyReceiver myReceiver;
    IntentFilter intentFilter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvMain);

    }

    @Override
    protected void onStart() {
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter(ACTION_OUTSIDE);
        registerReceiver(myReceiver,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }

    public class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Setting text");
            textView.setText(intent.getStringExtra(MY_KEY));
        }
    }
}
