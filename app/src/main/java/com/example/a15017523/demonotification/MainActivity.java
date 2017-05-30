package com.example.a15017523.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int reqCode = 123;
    int notificationID = 888;
    Button buttonNotify1, buttonNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNotify1 = (Button)findViewById(R.id.btnNotify1);
        buttonNotify2 = (Button)findViewById(R.id.btnNotify2);

        buttonNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.bigText("This is one big text");
                bigTextStyle.setBigContentTitle("Big - Long Content");
                bigTextStyle.setSummaryText("Reflection Journal?");

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Title");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setStyle(bigTextStyle);
                builder.setAutoCancel(true);

                Uri uri = RingtoneManager.getDefaultUri(
                        RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification notification = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, notification);
                finish();
            }
        });
    }
}
