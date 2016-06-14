package org.lehmann.natalia.queremoscomer.servicios;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.lehmann.natalia.queremoscomer.modelo.Menu;

/**
 * Created by natalia on 6/13/16.
 */
public class Storage {

    private static final String MENU_KEY = "menu";

    private static final String LOG_TAG = Storage.class.getName();

    public static Menu getMenu(Activity context) {

        SharedPreferences sharedPref = context.getPreferences(Context.MODE_PRIVATE);

        String menuStr = sharedPref.getString(MENU_KEY, null);

        Menu menu = null;

        if (menuStr != null) {

            Gson gson = new Gson();
            menu = gson.fromJson(menuStr, Menu.class);
        }

        return menu;
    }

    public static void saveMenu(Menu menu, Activity context) {

        SharedPreferences sharedPref = context.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        String menuJson = gson.toJson(menu);

        editor.putString(MENU_KEY, menuJson);
        editor.apply();
    }
}
