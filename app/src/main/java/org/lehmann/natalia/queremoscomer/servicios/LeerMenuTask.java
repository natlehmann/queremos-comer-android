package org.lehmann.natalia.queremoscomer.servicios;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.lehmann.natalia.queremoscomer.modelo.Menu;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by natalia on 6/13/16.
 */
public class LeerMenuTask extends AsyncTask<Void, Void, Void> {

    public static final String LOG_TAG = LeerMenuTask.class.getName();
    private ProgressDialog dialog;

    private Activity context;

    public LeerMenuTask(Activity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = ProgressDialog.show(context, "", "Please wait...");
    }

    @Override
    protected Void doInBackground(Void... params) {

        Menu menu = Storage.getMenu(context);

        if (menu == null) {
            menu = MenuService.armarMenu(context);
          //  Storage.saveMenu(menu, context);
            Log.d(LOG_TAG, "MENU ===================== " + menu);
        }

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
