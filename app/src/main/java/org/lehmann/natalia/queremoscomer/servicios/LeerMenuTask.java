package org.lehmann.natalia.queremoscomer.servicios;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by natalia on 6/13/16.
 */
public class LeerMenuTask extends AsyncTask<Void, Void, Void> {

    public static final String LOG_TAG = LeerMenuTask.class.getName();
    private ProgressDialog dialog;

    private Context context;

    public LeerMenuTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = ProgressDialog.show(context, "", "Please wait...");
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            JSONObject json = new JSONObject(loadJSONFromAsset());
            Log.i(LOG_TAG, "AVA VA " +  json.getJSONArray("primerPlato"));
            Log.i(LOG_TAG, "AVA VA " +  json.getJSONArray("guarnicion"));

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error al procesar archivo JSON ", e);
        }
        return null;
    }

    private String loadJSONFromAsset() {

        String json = null;
        try {
            InputStream is = context.getAssets().open("carta.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            Log.e(LOG_TAG, "Error al leer archivo JSON ", ex);
        }
        return json;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
