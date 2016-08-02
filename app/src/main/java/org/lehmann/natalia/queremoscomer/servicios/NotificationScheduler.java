package org.lehmann.natalia.queremoscomer.servicios;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.lehmann.natalia.queremoscomer.view.NotificationSender;

import java.util.Calendar;

public class NotificationScheduler extends BroadcastReceiver {

    private static final String LOG_TAG = NotificationScheduler.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(LOG_TAG, "Planificando envio de notificaciones");

        Intent myIntent = new Intent(context, NotificationSender.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar firingCal= Calendar.getInstance();
        Calendar currentCal = Calendar.getInstance();

        firingCal.set(Calendar.HOUR_OF_DAY, 13); // At the hour you wanna fire
        firingCal.set(Calendar.MINUTE, 55); // Particular minute
        firingCal.set(Calendar.SECOND, 0); // particular second

        long intendedTime = firingCal.getTimeInMillis();
        long currentTime = currentCal.getTimeInMillis();

        if(intendedTime < currentTime){
            firingCal.add(Calendar.DAY_OF_MONTH, 1);
            intendedTime = firingCal.getTimeInMillis();
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, intendedTime, AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
