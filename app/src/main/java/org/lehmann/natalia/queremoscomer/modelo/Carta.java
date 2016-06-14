package org.lehmann.natalia.queremoscomer.modelo;

import java.util.List;

/**
 * Created by natalia on 6/13/16.
 */
public class Carta {

    private List<Receta> primerPlato;
    private List<Receta> guarnicion;

    public List<Receta> getGuarnicion() {
        return guarnicion;
    }

    public void setGuarnicion(List<Receta> guarnicion) {
        this.guarnicion = guarnicion;
    }

    public List<Receta> getPrimerPlato() {
        return primerPlato;
    }

    public void setPrimerPlato(List<Receta> primerPlato) {
        this.primerPlato = primerPlato;
    }
}
