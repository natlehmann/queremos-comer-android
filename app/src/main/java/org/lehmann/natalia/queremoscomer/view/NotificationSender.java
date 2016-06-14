package org.lehmann.natalia.queremoscomer.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.lehmann.natalia.queremoscomer.servicios.NotificationService;

public class NotificationSender extends BroadcastReceiver {
    public NotificationSender() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationService.crearNotificacion(context);

        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        int interval = 10000;

        Intent alarmIntent = new Intent(context, NotificationSender.class);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 3000, PendingIntent.getBroadcast(context, 0, alarmIntent, 0));
    }
}
