package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by natalia on 6/13/16.
 */
public class Menu implements Serializable {

    private List<RecetaDia> recetas;

    private Date fechaDesde;
    private Date fechaHasta;

    public List<RecetaDia> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<RecetaDia> recetas) {
        this.recetas = recetas;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
