package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button notificationBtn;
    EditText etMessage;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationBtn = findViewById(R.id.notificationBtn);
        etMessage = findViewById(R.id.etMessage);
        notificationBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                String Id = "channel 1";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,Id)
                        .setContentTitle("My Notification")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pendingIntent)
                        .setContentText(etMessage.getText().toString());
                Notification notification = builder.build();
                notificationManager.notify(1,notification);
            }
        });

    }
}