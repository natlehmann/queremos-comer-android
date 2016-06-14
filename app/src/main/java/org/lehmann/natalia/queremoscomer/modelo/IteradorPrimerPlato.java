package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;

/**
 * Created by natalia on 6/13/16.
 */
public class IteradorPrimerPlato implements Serializable {

    private Categoria categoria;
    private int valor;

    public IteradorPrimerPlato(){}

    public IteradorPrimerPlato(Categoria categoria) {
        this.categoria = categoria;
        this.valor = 0;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
