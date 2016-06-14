package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by natalia on 6/13/16.
 */
public class Iteradores implements Serializable {

    private List<IteradorPrimerPlato> itPrimerPlato;
    private List<IteradorGuarnicion> itGuarnicion;

    private int itActual;

    public List<IteradorPrimerPlato> getItPrimerPlato() {
        return itPrimerPlato;
    }

    public void setItPrimerPlato(List<IteradorPrimerPlato> itPrimerPlato) {
        this.itPrimerPlato = itPrimerPlato;
    }

    public List<IteradorGuarnicion> getItGuarnicion() {
        return itGuarnicion;
    }

    public void setItGuarnicion(List<IteradorGuarnicion> itGuarnicion) {
        this.itGuarnicion = itGuarnicion;
    }

    public int getItActual() {
        return itActual;
    }

    public void setItActual(int itActual) {
        this.itActual = itActual;
    }
}
