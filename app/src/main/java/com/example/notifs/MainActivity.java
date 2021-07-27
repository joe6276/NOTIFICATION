package com.example.notifs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.notifs.App.CHANNEL_1_ID;
import static com.example.notifs.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat  notificationManager;
    private EditText title;
    private EditText message;
    private Button channel1, channel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
        title= findViewById(R.id.title);
        message= findViewById(R.id.message);
        channel1= findViewById(R.id.Channel1);
        channel2= findViewById(R.id.Channel2);
    }
    public  void SendOnChannel1(View v){

        String titlename= title.getText().toString();
        String messagename= message.getText().toString();
    Notification notification= new NotificationCompat.Builder(this,CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_first)
            .setContentTitle(titlename)
            .setContentText(messagename)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build();
    notificationManager.notify(1, notification);
    }

    public void sendOnChannelTwo(View V){

        String titlename= title.getText().toString();
        String messagename= message.getText().toString();
        Notification notification= new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(titlename)
                .setContentText(messagename)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2, notification);
    }
}