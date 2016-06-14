package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;

/**
 * Created by natalia on 6/13/16.
 */
public class RecetaCompuesta implements Serializable {

    private Receta primerPlato;
    private Receta guarnicion;

    public RecetaCompuesta(){}

    public RecetaCompuesta(Receta primerPlato, Receta guarnicion) {
        this.primerPlato = primerPlato;
        this.guarnicion = guarnicion;
    }


    public Receta getPrimerPlato() {
        return primerPlato;
    }

    public void setPrimerPlato(Receta primerPlato) {
        this.primerPlato = primerPlato;
    }

    public Receta getGuarnicion() {
        return guarnicion;
    }

    public void setGuarnicion(Receta guarnicion) {
        this.guarnicion = guarnicion;
    }

    @Override
    public String toString() {
        return this.primerPlato + " con " + this.guarnicion;
    }
}
