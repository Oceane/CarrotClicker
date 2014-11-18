package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    ImageButton Carrot;
    Button Buy;
    Button Restart;
    Button instructions;
    Button Personalize;
    public static int count = 0;
    public static int Earnings = 0;
    public static String success = "";
    TextView NumberOfCarrots;
    TextView Success;
    TextView CarrotEarning;
    TextView intro;
    int i = 0;
    public static Boolean add = true;
    boolean update = false;
    public static String UserName = "";
    public static int day = 0;
    public static int month = 0;
    public static int year = 0;
    public static String animal = "";
    public static String holiday = "";
    MediaPlayer mp;
    public static String ACTION_ADD_COUNT = "Add Count";
    public static String FINISH = "finish";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mp = MediaPlayer.create(this, R.raw.pop);

        Carrot = (ImageButton)this.findViewById(R.id.imageButton);
        NumberOfCarrots = (TextView)this.findViewById(R.id.textView2);
        NumberOfCarrots.setText(String.valueOf(count)+ " carrots");
        intro = (TextView)this.findViewById(R.id.PersonalTextview);
        if(UserName != "") {
            intro.setText("Welcome user: " + UserName);
        }
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = formatter.format(now.getTime());
        String[] separateCurrentDate = nowDate.split("-");
        String tempyear = separateCurrentDate[0];
        String tempmonth = separateCurrentDate[1];
        String tempday = separateCurrentDate[2];
        int currentYear = Integer.parseInt(tempyear);
        int currentMonth = Integer.parseInt(tempmonth);
        int currentDay = Integer.parseInt(tempday);
        if(add) {
            if (day != 0 && month != 0 && year != 0) {
                i = i + 1;
                if (currentDay == day && currentMonth == month && i == 1) {
                    int tempage = currentYear - year;
                    Birthdaynotification(tempage);
                    i = i - 1;
                    add = false;
                }
                else if(currentDay == 25 && currentMonth == 12 && i == 1){
                    if(currentDay == day && currentMonth == month && i == 1){
                        int tempage2 = currentYear - year;
                        ChristmasBirthdaynotification(tempage2);
                        i = i - 1;
                        add = false;
                    }else {
                        ChristmasNotification();
                        i = i - 1;
                        add = false;
                    }
                }
            }
        }
        Carrot.setSoundEffectsEnabled(false);
        Carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                NumberOfCarrots.setText(String.valueOf(count) + " carrots");
                mp.start();
                mp.setAudioStreamType(AudioManager.STREAM_RING);
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
        Personalize = (Button)this.findViewById(R.id.PersonalButton);
        Personalize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Personalize.getText().equals("Profile")) {
                    Intent intent = new Intent(context, PersonalizePage.class);
                    startActivity(intent);
                }
            }
        });
        instructions = (Button)this.findViewById(R.id.InstructionButton);
        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(instructions.getText().equals("Instructions")) {
                    Intent intent = new Intent(context, settings.class);
                    startActivity(intent);
                }
            }
        });
        Success = (TextView) this.findViewById(R.id.textView6);


        CarrotEarning = (TextView) this.findViewById(R.id.textView5);
        CarrotEarning.setText(String.valueOf(Earnings)+" Carrot(s) per minutes");
        Restart = (Button)this.findViewById(R.id.Restart);
        Restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Restart.getText().equals("Restart")) {
                    count = 0;
                    NumberOfCarrots.setText(String.valueOf(count)+ " carrots");
                    Earnings = 0;
                    CarrotEarning.setText(String.valueOf(Earnings)+" Carrot(s) per minutes");
                    Success.setText("");
                    success = "";
                    UserName = "";
                    animal = "";
                    holiday = "";
                    day = 0;
                    month = 0;
                    year = 0;
                    intro.setText("");
                    onStop();
                    onCreate(savedInstanceState);

                }
            }
        });
        // Comment
        if(update){
            success = "";
            Success.setText("");
            update = false;
        }else{
            if(success != "") {
                Toast.makeText(this, success, Toast.LENGTH_SHORT).show();
            }
            Success.setText(success);
        }
        //AddEarnings(Earnings);
        final Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NumberOfCarrots.setText(String.valueOf(count)+ " carrots");
                        Success.setText("");
                    }
                });

            }
        }, 1000, 1000);

        final Timer T2=new Timer();
        T2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                        count += Earnings;

            }
        }, 30000, 30000);

        notification();
    }

    public void upgradeString(int hello){
        NumberOfCarrots.setText(String.valueOf(hello));
        //Success.setText("");
    }

    public void notification(){
        final Intent removeIntent = new Intent( ACTION_ADD_COUNT, null, this, WearIntent.class );
        final PendingIntent pendingRemoveIntent = PendingIntent.getActivity( this, 0, removeIntent, PendingIntent.FLAG_UPDATE_CURRENT );
        final Intent removeIntent2 = new Intent( ACTION_ADD_COUNT, null, this, NotifyMe.class );
        final PendingIntent pendingRemoveIntent2 = PendingIntent.getActivity( this, 0, removeIntent2, PendingIntent.FLAG_UPDATE_CURRENT );
        final Context context = this;
        final Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(count%100 == 0 && count > 0){

                    //Intent intent = new Intent(context, NotifyMe.class);
                    //startActivity(intent);
                removeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder( MainActivity.this )
                        .setSmallIcon( R.drawable.ic_launcher )
                        .setContentTitle( "Carrot level up!!" )
                        .setContentText("You have: " + String.valueOf(count) + " Carrots")
                        .setContentIntent(pendingRemoveIntent)
                        .setVibrate(new long[]{0, 200, 100, 200})
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                        .addAction(R.drawable.ic_launcher, "Press to get 1 extra carrot", pendingRemoveIntent);
                        //.addAction(R.drawable.ic_launcher, "Click me to start playing on your phone again", pendingRemoveIntent2);


                 NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//NotificationManagerCompat.from(MainActivity.this);
                 notificationManager.notify(001, notificationBuilder.build());
                }
            }
        },5000,5000);
       // final Intent actionIntent = new Intent(ACTION_ADD_COUNT,null,this, WearIntent.class);
       // final PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent,PendingIntent.FLAG_UPDATE_CURRENT);

       /* final Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(count%100 == 0 && count > 0){
                    int notificationId = 001;

                    NotificationCompat.Builder notificationBuilder =
                            new NotificationCompat.Builder(MainActivity.this)
                                    .setSmallIcon(R.drawable.ic_launcher)
                                    .setContentTitle("Carrot level up!!")
                                    .setContentText("You have: " + String.valueOf(count) + " Carrots")
                                    .setVibrate(new long[]{0, 200, 100, 200})//500,250,500
                                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                                    .addAction(new NotificationCompat.Action.Builder(R.drawable.ic_launcher, "press here to get extra carrots", actionPendingIntent).build())
                                    .extend(new NotificationCompat.WearableExtender().setContentAction(0));




                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

                    notificationManager.notify(notificationId, notificationBuilder.build());
                }
            }
        },5000,5000);*/
    }
    public void Birthdaynotification(int age){
        int notificationId = 001;
        count += 100;
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Happy Birthday!!")
                        .setContentText("You are now "+ String.valueOf(age) +" years old, and for that you have received 100 extra carrots. \nHappy Harvest!")
                        .setVibrate(new long[]{0, 200, 100, 200})//500,250,500
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
    public void ChristmasBirthdaynotification(int age){
        int notificationId = 001;
        count += 150;
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Happy Birthday and Merry Christmas!!")
                        .setContentText("You are now "+ String.valueOf(age) +" years old, and it's christmas!!! So here is 150 extra carrots. \nHappy Harvest!")
                        .setVibrate(new long[]{0, 200, 100, 200})//500,250,500
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
    public void ChristmasNotification(){
        int notificationId = 001;
        count += 50;
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Merry Christmas!!")
                        .setContentText("Have a joly good christmas.\nHere is 50 extra carrots for you. \nHappy Harvest!")
                        .setVibrate(new long[]{0, 200, 100, 200})//500,250,500
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

        notificationManager.notify(notificationId, notificationBuilder.build());
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
