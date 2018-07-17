package com.mobileapps.training.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    public static final String MY_ACTION = "my_action";

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED: {
                boolean state = intent.getBooleanExtra("state", false);
                Log.d(TAG, "onReceive: Airplane state:" + state);
                break;
            }
            case MY_ACTION:{
                Log.d(TAG, "onReceive: MyAction received");
                String data = intent.getStringExtra("myKey");
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
