package org.lehmann.natalia.queremoscomer.servicios;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import org.lehmann.natalia.queremoscomer.MenuSemanalActivity;
import org.lehmann.natalia.queremoscomer.R;
import org.lehmann.natalia.queremoscomer.modelo.RecetaCompuesta;

/**
 * Created by natalia on 6/14/16.
 */
public class NotificationService {

    public static void crearNotificacion(Context context) {

        RecetaCompuesta receta = MenuService.getRecetaParaAhora(context);

        if (receta != null) {


            Intent notificationIntent = new Intent(context,
                    MenuSemanalActivity.class);

            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP); // To open only one activity

            // Invoking the default notification service

            NotificationManager mNotificationManager;
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    context);

            mBuilder.setSmallIcon(R.drawable.ic_tenedor);
            mBuilder.setContentTitle("Hoy comemos");
            mBuilder.setContentText(receta.toString());
            mBuilder.setAutoCancel(true);

            Uri uri = RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            mBuilder.setSound(uri);

            // Add Big View Specific Configuration
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            String[] events = new String[]{receta.toString()};


            // Sets a title for the Inbox style big view
            inboxStyle.setBigContentTitle("Hoy comemos");

            // Moves events into the big view
            for (int i = 0; i < events.length; i++) {
                inboxStyle.addLine(events[i]);
            }

            mBuilder.setStyle(inboxStyle);

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

            mBuilder.setContentIntent(resultPendingIntent);
            mNotificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.notify(1, mBuilder.build());

        }
    }

}
