package org.lehmann.natalia.queremoscomer.servicios;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.ic_tenedor)
                            .setContentTitle("Hoy comemos")
                            .setContentText(receta.toString())
                            .setCategory(NotificationCompat.CATEGORY_EVENT);

            NotificationCompat.BigTextStyle inboxStyle =
                    new NotificationCompat.BigTextStyle();
            inboxStyle.setBigContentTitle("Event tracker details:");
            mBuilder.setStyle(inboxStyle);

            Intent resultIntent = new Intent(context, MenuSemanalActivity.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(MenuSemanalActivity.class);
            stackBuilder.addNextIntent(resultIntent);

            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.notify(1, mBuilder.build());
        }
    }

}
