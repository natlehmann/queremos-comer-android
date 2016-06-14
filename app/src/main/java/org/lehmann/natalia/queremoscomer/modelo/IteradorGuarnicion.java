package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;

/**
 * Created by natalia on 6/13/16.
 */
public class IteradorGuarnicion implements Serializable {

    private Tipo tipo;
    private int valor;

    public IteradorGuarnicion(){}

    public IteradorGuarnicion(Tipo tipo) {
        this.tipo = tipo;
        this.valor = 0;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
