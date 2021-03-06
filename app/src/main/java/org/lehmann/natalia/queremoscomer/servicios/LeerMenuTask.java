package org.lehmann.natalia.queremoscomer.servicios;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.lehmann.natalia.queremoscomer.MenuSemanalActivity;
import org.lehmann.natalia.queremoscomer.modelo.Menu;

/**
 * Created by natalia on 6/13/16.
 */
public class LeerMenuTask extends AsyncTask<Void, Void, Void> {

    public static final String LOG_TAG = LeerMenuTask.class.getName();
    private ProgressDialog dialog;

    private MenuSemanalActivity context;

    public LeerMenuTask(MenuSemanalActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = ProgressDialog.show(context, "", "Un momento por favor...");
    }

    @Override
    protected Void doInBackground(Void... params) {

        Menu menu = MenuService.getMenu(context);
        context.setMenuAdapter(menu);

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
