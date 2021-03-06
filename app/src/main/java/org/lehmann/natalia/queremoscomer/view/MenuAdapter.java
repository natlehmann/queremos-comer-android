package org.lehmann.natalia.queremoscomer.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.lehmann.natalia.queremoscomer.R;
import org.lehmann.natalia.queremoscomer.modelo.Menu;
import org.lehmann.natalia.queremoscomer.modelo.RecetaDia;
import org.lehmann.natalia.queremoscomer.servicios.MenuService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by natalia on 6/14/16.
 */
public class MenuAdapter extends BaseAdapter {

    private Menu menu;
    private Activity context;
    private static LayoutInflater inflater=null;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd", new Locale("es"));

    public MenuAdapter(Menu menu, Activity context) {
        this.menu = menu;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return menu.getRecetas().size();
    }

    @Override
    public Object getItem(int position) {
        return menu.getRecetas().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if (convertView == null) {
            view = inflater.inflate(R.layout.row_menu, null);
            holder = new ViewHolder();

            holder.fecha = (TextView) view.findViewById(R.id.fecha);
            holder.almuerzo = (TextView) view.findViewById(R.id.almuerzo);
            holder.cena = (TextView) view.findViewById(R.id.cena);
            holder.fila = view.findViewById(R.id.fila);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        RecetaDia receta = menu.getRecetas().get(position);
        holder.fecha.setText(dateFormat.format(receta.getFecha()));
        holder.almuerzo.setText(receta.getAlmuerzo().toString());
        holder.cena.setText(receta.getCena().toString());

        Date hoy = MenuService.getFechaHoy().getTime();
        if (hoy.getTime() == receta.getFecha().getTime()) {
            holder.fila.setBackgroundColor(context.getColor(R.color.colorAccent_transp));

        } else {
            holder.fila.setBackgroundColor(context.getColor(android.R.color.white));
        }


        return view;
    }

    public static class ViewHolder {
        TextView fecha;
        TextView almuerzo;
        TextView cena;
        View fila;
    }
}
