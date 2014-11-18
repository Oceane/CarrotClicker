package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Enkaichen on 11/17/14.
 */
public class NotifyMe extends Activity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent2);
    }
/*   private NotificationManager mNotificationManager;
    private int SIMPLE_NOTFICATION_ID;

    public void onReceive(Context context, Intent intent){
        Intent notificationIntent = new Intent(context, WearIntent.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = context.getResources();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher))
                .setTicker("press me")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Message")
                .setContentText("More Carrots");
        Notification n = builder.getNotification();

        n.defaults |= Notification.DEFAULT_ALL;
        nm.notify(0, n);
    }*/
}
