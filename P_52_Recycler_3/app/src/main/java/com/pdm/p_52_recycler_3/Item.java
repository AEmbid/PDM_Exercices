package com.pdm.p_52_recycler_3;


import android.graphics.drawable.Drawable;

public class Item {
    String ciudad;
    String descripcion;
    Drawable foto;

    public Item(String ciudad, String descripcion, Drawable foto) {
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Drawable getFoto() {
        return foto;
    }
}
