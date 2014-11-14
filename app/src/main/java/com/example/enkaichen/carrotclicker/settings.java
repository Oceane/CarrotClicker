package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Enkaichen on 11/11/14.
 */
public class settings extends Activity {
    Button Back;//#FFA500
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.settings);
        Back = (Button) this.findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Back.getText().equals("Back")) {
                        MainActivity.add = false;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                }
            }
        });
    }
}
