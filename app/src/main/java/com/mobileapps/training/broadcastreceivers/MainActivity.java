package com.mobileapps.training.broadcastreceivers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    MyReceiver myReceiver;
    IntentFilter intentFilter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");

        editText = findViewById(R.id.etMain);
    }

    @Override
    protected void onStart() {
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(MyReceiver.MY_ACTION);
        //registerReceiver(myReceiver, intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
        super.onStop();
    }

    public void sendBroadcast(View view) {
        Log.d(TAG, "sendBroadcast: ");
        String data = editText.getText().toString();
        Intent intent = new Intent(MyReceiver.MY_ACTION);
        intent.putExtra("myKey",data);
        sendBroadcast(intent);
    }

    public void sendBroadcastOut(View view) {
        Log.d(TAG, "sendBroadcastOut: ");
        String data = editText.getText().toString();
        Intent intent = new Intent("actionOut");
        intent.putExtra("myKey",data);
        sendBroadcast(intent);
    }
}
