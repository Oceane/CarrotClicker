package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Enkaichen on 11/16/14.
 */
public class WearIntent extends Activity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        MainActivity.count = MainActivity.count+1;
        finish();
        //Intent intent2 = new Intent(this, MainActivity.class);
        //intent2.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        //startActivity(intent2);
    }

  /*  @Override
    protected void onHandleIntent(Intent intent) {
        MainActivity.count ++;
        Intent intent2 = new Intent(this, MainActivity.class);
        intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent2);
    }*/
}
