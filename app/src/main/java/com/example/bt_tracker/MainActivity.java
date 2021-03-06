package com.example.bt_tracker;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mainButton1 = findViewById(R.id.MainButton1);
        mainButton1.setOnClickListener(this);
        TextView Subbutton = findViewById(R.id.Subbutton);
        Subbutton.setOnClickListener(this);
    }



    public void gotoLogActivity(View view) {
        Intent toLog= new Intent(this,LogActivity.class);
   startActivity(toLog);
    }

    public void goToNormalActivity(View view) {
        Intent toNormal = new Intent(this, NormalActivity.class);
        startActivity(toNormal);
    }

    public void goToMechanismActivity(View view) {
        Intent toMechanism = new Intent(this, MechanismActivity.class);
        startActivity(toMechanism);
    }

    public void goToHandleActivity(View view) {
        Intent toHandle = new Intent(this, HandleActivity.class);
        startActivity(toHandle);}
    public void setReminder(View view){
        // When user clicks "SET REMINDER" button, a toast message will
// pop up to let user know that a reminder is set
        Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
// Create an intent object to start
// the ReminderBroadcastReceiver class
        Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
// Create a pending intent so that the intent object above
// will only fire when alarm triggers
        PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
// create an AlarmManager
        AlarmManager alarmManager =
                (AlarmManager) getSystemService(ALARM_SERVICE);
// Repeating interval for the alarmManager is set to 6 second
// for demonstration purpose
// In real world application, users may want to get daily
// // In that case, set the interval to 1000 * 60 * 60 * 24
        long interval = 1000 * 6;
// set up a repeating alarm so that the notification reminder
// gets fired at the set interval
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), interval, pd);}
    private void createNotificationChannel(){
// First, check SDK version
// Create notification channel only if SDK version > Android 8 Oreo
// CAUTION: It's Oreo's O, not number 0!!!
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID,
                    channelName, importance);
            channel.setDescription(channelDescription);
// Create a notification manager
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
// Create notification channel
            notificationManager.createNotificationChannel(channel);        }
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainButton1:
// If MainButton1 is clicked, do something
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;
            case R.id.Subbutton:
            // When user clicks "SET REMINDER" button, a toast message will
// pop up to let user know that a reminder is set
            Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
// Create an intent object to start
// the ReminderBroadcastReceiver class
            Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
// Create a pending intent so that the intent object above
// will only fire when alarm triggers
            PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
// create an AlarmManager
            AlarmManager alarmManager =
                    (AlarmManager) getSystemService(ALARM_SERVICE);
// Repeating interval for the alarmManager is set to 6 second
// for demonstration purpose
// In real world application, users may want to get daily
// // In that case, set the interval to 1000 * 60 * 60 * 24
            long interval = 1000 * 6;
// set up a repeating alarm so that the notification reminder
// gets fired at the set interval
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(), interval, pd);}
// First, check SDK version
// Create notification channel only if SDK version > Android 8 Oreo
// CAUTION: It's Oreo's O, not number 0!!!
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String channelID = "BT_Tracker_Channel";
                String channelName = "BTTrackerReminderChannel";
                String channelDescription = "Channel for BT Tracker reminder";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(channelID,
                        channelName, importance);
                channel.setDescription(channelDescription);
// Create a notification manager
                NotificationManager notificationManager =
                        getSystemService(NotificationManager.class);
// Create notification channel
                notificationManager.createNotificationChannel(channel); }

    }

}