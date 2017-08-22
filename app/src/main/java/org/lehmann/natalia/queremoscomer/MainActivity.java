package org.lehmann.natalia.queremoscomer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.lehmann.natalia.queremoscomer.servicios.NotificationService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationService.scheduleNotification(this);

        Intent intent = new Intent(this, MenuSemanalActivity.class);
        startActivity(intent);

        finish();
    }

}
