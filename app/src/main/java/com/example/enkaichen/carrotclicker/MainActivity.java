package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    ImageButton Carrot;
    Button Buy;
    Button Restart;
    public static int count = 0;
    public static int Earnings = 0;
    public static String success = "";
    TextView NumberOfCarrots;
    TextView Success;
    TextView CarrotEarning;
    int i = 0;
    boolean update = false;
    final Timer T = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_main);
        Carrot = (ImageButton)this.findViewById(R.id.imageButton);
        NumberOfCarrots = (TextView)this.findViewById(R.id.textView2);
        NumberOfCarrots.setText(String.valueOf(count));
        Carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                NumberOfCarrots.setText(String.valueOf(count));
            }
        });

        Buy = (Button)this.findViewById(R.id.BuyButton);
        Buy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Buy.getText().equals("Buy")) {
                    Intent intent = new Intent(context, Buy.class);
                    startActivity(intent);
                }
            }
        });
        Success = (TextView) this.findViewById(R.id.textView6);


        CarrotEarning = (TextView) this.findViewById(R.id.textView5);
        CarrotEarning.setText(String.valueOf(Earnings));
        Restart = (Button)this.findViewById(R.id.Restart);
        Restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Restart.getText().equals("Restart")) {
                    count = 0;
                    NumberOfCarrots.setText(String.valueOf(count));
                    Earnings = 0;
                    CarrotEarning.setText(String.valueOf(Earnings));
                    Success.setText("");
                    success = "";
                    AddEarnings(Earnings);
                }
            }
        });
        // Comment
        if(update){
            success = "";
            Success.setText("");
            update = false;
        }else{
            Success.setText(success);
        }
        final int num = Earnings;
        AddEarnings(num);
        notification();
    }

    public void AddEarnings(final int carrots){
        T.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                count +=carrots;
            }
        },30000,30000);
    }

    public void notification(){
        final Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(count%10 == 0 && count > 0){
                    int notificationId = 001;

                    NotificationCompat.Builder notificationBuilder =
                            new NotificationCompat.Builder(MainActivity.this)
                                    .setSmallIcon(R.drawable.ic_launcher)
                                    .setContentTitle("Carrot level up!!")
                                    .setContentText("You have:" + String.valueOf(count))
                                    .setVibrate(new long[]{0, 500, 250, 500})
                                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

                    notificationManager.notify(notificationId, notificationBuilder.build());
                }
            }
        },1000,1000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
