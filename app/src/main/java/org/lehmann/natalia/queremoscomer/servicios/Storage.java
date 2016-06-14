package org.lehmann.natalia.queremoscomer.servicios;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.lehmann.natalia.queremoscomer.modelo.Categoria;
import org.lehmann.natalia.queremoscomer.modelo.IteradorGuarnicion;
import org.lehmann.natalia.queremoscomer.modelo.IteradorPrimerPlato;
import org.lehmann.natalia.queremoscomer.modelo.Iteradores;
import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.modelo.Tipo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by natalia on 6/13/16.
 */
public class Storage {

    private static final String MENU_KEY = "menu";
    private static final String ITERADORES_KEY = "iteradores";

    private static final String LOG_TAG = Storage.class.getName();

    public static Menu getMenu(Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences(
                Storage.class.getName(), Context.MODE_PRIVATE);

        String menuStr = sharedPref.getString(MENU_KEY, null);

        Menu menu = null;

        if (menuStr != null) {

            Gson gson = new Gson();
            menu = gson.fromJson(menuStr, Menu.class);
        }

        return menu;
    }

    public static void saveMenu(Menu menu, Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences(
                Storage.class.getName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        String menuJson = gson.toJson(menu);

        editor.putString(MENU_KEY, menuJson);
        editor.apply();
    }

    public static Iteradores getIteradores(Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences(
                Storage.class.getName(), Context.MODE_PRIVATE);

        String iteradoresStr = sharedPref.getString(ITERADORES_KEY, null);

        Iteradores it = null;

        if (iteradoresStr != null) {

            Gson gson = new Gson();
            it = gson.fromJson(iteradoresStr, Iteradores.class);
        }

        if (it == null) {

            it = new Iteradores();

            List<IteradorGuarnicion> iteradoresGuarnicion= new LinkedList<>();
            for (Tipo tipo : Tipo.values()) {
                iteradoresGuarnicion.add(new IteradorGuarnicion(tipo));
            }
            it.setItGuarnicion(iteradoresGuarnicion);

            List<IteradorPrimerPlato> iteradoresPrimerPlato = new LinkedList<>();
            for (Categoria categoria : Categoria.values()) {
                iteradoresPrimerPlato.add(new IteradorPrimerPlato(categoria));
            }
            it.setItPrimerPlato(iteradoresPrimerPlato);
        }

        return it;
    }

    public static void saveIteradores(Iteradores iteradores, Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences(
                Storage.class.getName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        String json = gson.toJson(iteradores);

        editor.putString(ITERADORES_KEY, json);
        editor.apply();
    }
}
