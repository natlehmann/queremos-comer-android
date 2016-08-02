package org.lehmann.natalia.queremoscomer.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.lehmann.natalia.queremoscomer.servicios.NotificationService;

public class NotificationSender extends BroadcastReceiver {

    private static final String LOG_TAG = NotificationSender.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(LOG_TAG, "Armando notificacion local");
        NotificationService.crearNotificacion(context);

    }
}
