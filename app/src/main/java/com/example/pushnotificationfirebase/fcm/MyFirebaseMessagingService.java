package com.example.pushnotificationfirebase.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.example.pushnotificationfirebase.MainActivity;
import com.example.pushnotificationfirebase.MyApplication;
import com.example.pushnotificationfirebase.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull @org.jetbrains.annotations.NotNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        //Notification message
        /*RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification == null) {
            return;
        }
        String title = notification.getTitle();
        String message = notification.getBody();

        sendNotification(title, message);*/

        //Data message
        //B1: server chon device nao muon gui, gui nhung j se setup tren server
        //B2: firebase la trung gian nhan yc tu server gui notification toi dung device
        //B3: client lang nghe data firebase tra ve roi hien thi len notification
        //test tren post man  (POST)
        Map<String, String> stringMap = remoteMessage.getData();
        String title = stringMap.get("user_name");
        String contentMessage = stringMap.get("description");

        sendNotification(title, contentMessage);
    }

    private void sendNotification(String title, String message) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_baseline_ac_unit_24)
                .setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(getNotificationId(), notification);
        }

    }

    private int getNotificationId() {
        return (int) new Date().getTime();
    }

    @Override
    public void onNewToken(@NonNull @NotNull String token) {
        super.onNewToken(token);
        Log.d("123123", "onNewToken: "+ token);
    }
}

// data message
//Headers
//Authorization  key=AAAALmHTm0g:APA91bFXzqXLcQxUA4ZHEw_L113pVLEniStlthuqdKVbhm5QJi83irs7GIokl7SsyQmdZUEsvUS86vOEFE5xWF3otVngvDSmRm3JmvFJXkevLSTxXKqOOHGUP88UsrBR2ar-G8L1NwN7
//Content-Type   application/json

//Body (raw)
/*{
        "data" : {
        "user_name" : "TMV",
        "description" : "Than Manh Vinh"
        },
        "to" : "dIzBvuGWSy25vJjHNduGtD:APA91bH5A1d5p297-BsGbBM-Btds-76ZgqX8jTfFJZeQcSzdJvoFy4lCk0ciaMagOFbm-ATD5jnirnsxlCYwnvWqNyGrqYAj6GLMf-Ekc__tc1gx48rMQUjcxb9iqLYcEvuKsoK_u1Dj"
        }*/

//to: token firebase device



