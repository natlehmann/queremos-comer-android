package org.lehmann.natalia.queremoscomer.modelo;

import java.io.Serializable;

/**
 * Created by natalia on 6/13/16.
 */
public class Receta implements Serializable {

    private Integer id;
    private String nombre;
    private Categoria categoria;
    private Tipo tipo;
    private Tipo complemento;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getComplemento() {
        return complemento;
    }

    public void setComplemento(Tipo complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return this.nombre + " - cat:" + this.categoria + " - tipo: " + this.tipo;
    }
}
