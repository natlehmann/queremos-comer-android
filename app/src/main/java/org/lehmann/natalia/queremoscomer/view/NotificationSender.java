package org.lehmann.natalia.queremoscomer.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.lehmann.natalia.queremoscomer.servicios.MenuService;
import org.lehmann.natalia.queremoscomer.servicios.NotificationService;

public class NotificationSender extends BroadcastReceiver {

    private static final String LOG_TAG = NotificationSender.class.getName();

    public NotificationSender() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationService.crearNotificacion(context);

        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        long interval = MenuService.getTiempoHastaProximoAviso();

        Log.i(LOG_TAG, "Programando proxima alarma para dentro de " + interval / 1000 / 60);
        Intent alarmIntent = new Intent(context, NotificationSender.class);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, interval,
                PendingIntent.getBroadcast(context, 0, alarmIntent, 0));
    }
}
