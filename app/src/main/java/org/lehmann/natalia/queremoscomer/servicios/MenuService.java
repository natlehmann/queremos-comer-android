package org.lehmann.natalia.queremoscomer.servicios;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.lehmann.natalia.queremoscomer.modelo.Carta;
import org.lehmann.natalia.queremoscomer.modelo.Categoria;
import org.lehmann.natalia.queremoscomer.modelo.IteradorGuarnicion;
import org.lehmann.natalia.queremoscomer.modelo.IteradorPrimerPlato;
import org.lehmann.natalia.queremoscomer.modelo.Iteradores;
import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.modelo.Receta;
import org.lehmann.natalia.queremoscomer.modelo.RecetaCompuesta;
import org.lehmann.natalia.queremoscomer.modelo.Tipo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

        Map<Categoria, List<Receta>> primerosPlatos = armarMapaPrimerPlato(carta);
        Map<Tipo, List<Receta>> guarniciones = clasificarGuarniciones(carta);

        Iteradores iteradores = Storage.getIteradores(context);

        Calendar cal = getFechaHoy();

        for (int i=0; i < 7; i++) {

            RecetaCompuesta almuerzo = getSiguienteReceta(primerosPlatos, guarniciones, iteradores);
            RecetaCompuesta cena = getSiguienteReceta(primerosPlatos, guarniciones, iteradores);

            menu.addReceta(almuerzo, cena, cal.getTime());

            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        Storage.saveIteradores(iteradores, context);

        return menu;
    }

    @NonNull
    public static Calendar getFechaHoy() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    private static RecetaCompuesta getSiguienteReceta(Map<Categoria, List<Receta>> primerosPlatos,
                                             Map<Tipo, List<Receta>> guarniciones,
                                             Iteradores iteradores) {



        IteradorPrimerPlato itPP = iteradores.getItPrimerPlato().get(iteradores.getItActual());
        Receta receta = primerosPlatos.get(itPP.getCategoria()).get(itPP.getValor());


        IteradorGuarnicion itGuar = iteradores.getItGuarnicion().get(Tipo.LIVIANO.ordinal());

        if (receta.getComplemento() == Tipo.PESADO) {
            itGuar = iteradores.getItGuarnicion().get(Tipo.PESADO.ordinal());
        }

        Receta guarnicion = guarniciones.get(itGuar.getTipo()).get(itGuar.getValor());

        itPP.setValor(itPP.getValor() + 1);
        if (itPP.getValor() >= primerosPlatos.get(itPP.getCategoria()).size()) {
            itPP.setValor(0);
        }

        itGuar.setValor(itGuar.getValor() + 1);
        if (itGuar.getValor() >= guarniciones.get(itGuar.getTipo()).size()) {
            itGuar.setValor(0);
        }

        iteradores.setItActual(iteradores.getItActual() + 1);
        if (iteradores.getItActual() >= Categoria.values().length) {
            iteradores.setItActual(0);
        }

        return new RecetaCompuesta(receta, guarnicion);
    }


    private static Map<Tipo,List<Receta>> clasificarGuarniciones(Carta carta) {

        Map<Tipo,List<Receta>> mapa = new HashMap<>();

        for (Receta receta : carta.getGuarnicion()) {

            List<Receta> recetas = mapa.get(receta.getTipo());
            if (recetas == null) {
                recetas = new LinkedList<>();
                mapa.put(receta.getTipo(), recetas);
            }

            recetas.add(receta);
        }

        return mapa;
    }

    private static Map<Categoria,List<Receta>> armarMapaPrimerPlato(Carta carta) {

        Map<Categoria, List<Receta>> mapa = new HashMap<>();

        for (Receta receta : carta.getPrimerPlato()) {

            List<Receta> recetas = mapa.get(receta.getCategoria());
            if (recetas == null) {
                recetas = new LinkedList<>();
                mapa.put(receta.getCategoria(), recetas);
            }

            recetas.add(receta);
        }

        return mapa;
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
