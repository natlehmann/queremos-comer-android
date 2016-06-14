package org.lehmann.natalia.queremoscomer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.servicios.LeerMenuTask;

public class MenuSemanalActivity extends AppCompatActivity {

    private Menu menu;
    private ListView menuTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_semanal);

        menuTable = (ListView) findViewById(R.id.menu_semanal);

        new LeerMenuTask(this).execute();
    }
}
