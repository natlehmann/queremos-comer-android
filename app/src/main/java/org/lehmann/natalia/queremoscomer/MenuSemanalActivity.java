package org.lehmann.natalia.queremoscomer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.servicios.LeerMenuTask;
import org.lehmann.natalia.queremoscomer.view.MenuAdapter;

public class MenuSemanalActivity extends AppCompatActivity {

    private Menu menu;
    private ListView menuTable;

    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_semanal);

        menuTable = (ListView) findViewById(R.id.menu_semanal);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuTable.addHeaderView(inflater.inflate(R.layout.row_menu_header, null), null, false);

        new LeerMenuTask(this).execute();
    }

    public void setMenuAdapter(final Menu menu) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new MenuAdapter(menu, MenuSemanalActivity.this);
                menuTable.setAdapter(adapter);
            }
        });
    }

}
