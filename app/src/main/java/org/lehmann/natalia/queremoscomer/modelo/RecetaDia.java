package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by natalia on 6/13/16.
 */
public class RecetaDia implements Serializable {

    private Date fecha;
    private Receta almuerzo;
    private Receta cena;

    public RecetaDia(){}

    public RecetaDia(Receta almuerzo, Receta cena, Date fecha) {
        this.almuerzo = almuerzo;
        this.cena = cena;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Receta getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(Receta almuerzo) {
        this.almuerzo = almuerzo;
    }

    public Receta getCena() {
        return cena;
    }

    public void setCena(Receta cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "fecha: " + this.fecha + "almuerzo: " + this.almuerzo + " - cena: " + this.cena;
    }
}
