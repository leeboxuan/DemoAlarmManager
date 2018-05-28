package com.weebly.leeboxuan.demoalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSetAlarm;
    AlarmManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetAlarm = (Button) this.findViewById(R.id.btnAlarm);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                // Create pending intent to add it to the alarm manager

                Intent intent = new Intent(MainActivity.this, AlarmReceiverActivity.class);
                int reqcode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, reqcode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                // get alarmManager instance

                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

                // set the alarm
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            }
        });
    }
}
