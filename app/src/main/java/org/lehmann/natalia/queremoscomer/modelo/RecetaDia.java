package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by natalia on 6/13/16.
 */
public class RecetaDia implements Serializable {

    private Date fecha;
    private RecetaCompuesta almuerzo;
    private RecetaCompuesta cena;

    public RecetaDia(){}

    public RecetaDia(RecetaCompuesta almuerzo, RecetaCompuesta cena, Date fecha) {
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

    public RecetaCompuesta getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(RecetaCompuesta almuerzo) {
        this.almuerzo = almuerzo;
    }

    public RecetaCompuesta getCena() {
        return cena;
    }

    public void setCena(RecetaCompuesta cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "fecha: " + this.fecha + "almuerzo: " + this.almuerzo + " - cena: " + this.cena;
    }
}
