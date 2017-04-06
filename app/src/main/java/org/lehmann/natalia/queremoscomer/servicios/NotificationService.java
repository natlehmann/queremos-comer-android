package org.lehmann.natalia.queremoscomer.servicios;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import org.lehmann.natalia.queremoscomer.MenuSemanalActivity;
import org.lehmann.natalia.queremoscomer.R;
import org.lehmann.natalia.queremoscomer.modelo.RecetaCompuesta;

/**
 * Created by natalia on 6/14/16.
 */
public class NotificationService {

    public static void scheduleNotification(Context context) {

        Intent notificationIntent = new Intent(context, NotificationReceiver.class);
        notificationIntent.putExtra(NotificationReceiver.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationReceiver.NOTIFICATION, crearNotificacion(context));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + 10; // delay ????
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    public static Notification crearNotificacion(Context context) {

        RecetaCompuesta receta = MenuService.getRecetaParaAhora(context);

        Intent notificationIntent = new Intent(context,
                MenuSemanalActivity.class);

        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP); // To open only one activity


        Notification.Builder builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.ic_tenedor);
        builder.setContentTitle("Hoy comemos");
        builder.setContentText(receta.toString());
//            builder.setAutoCancel(true);

        Uri uri = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);


        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context,
                MenuSemanalActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder
                .create(context);
        stackBuilder.addParentStack(MenuSemanalActivity.class);


        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        return builder.build();

    }

}
