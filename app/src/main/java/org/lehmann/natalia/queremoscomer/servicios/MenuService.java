package org.lehmann.natalia.queremoscomer.servicios;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.lehmann.natalia.queremoscomer.modelo.Carta;
import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.modelo.Receta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by natalia on 6/13/16.
 */
public class MenuService {

    public static final String LOG_TAG = MenuService.class.getName();

    public static Menu armarMenu(Activity context) {


        String json = loadJSONFromAsset(context);
        Gson gson = new Gson();
        Carta carta = gson.fromJson(json, Carta.class);

        Menu menu = new Menu();

        for (Receta receta : carta.getPrimerPlato()) {
            menu.addReceta(receta, receta, new Date());
        }

        return menu;
    }

    private static String loadJSONFromAsset(Activity context) {

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
}
