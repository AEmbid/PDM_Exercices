package com.pdm.p_29_listview_personalizado_01;

import android.graphics.drawable.Drawable;

/**
 * Created by alu on 10/11/2016.
 */

public class Item {
    /*
     * simplemente es una clase que contendrá las variables necesarias para
     * almacenar los elementos que más tarde queremos que aparezcan en el
     * ListView. En nuestro caso:
     * long id: posición del ítem dentro de la lista
     * String api: texto que aparece en el ítem
     * Drawable imagen: imagen que aparece en el ítem
     */
    long id;
    String api;
    Drawable imagen;

    public Item(Drawable imagen, long id, String api) {
        this.imagen = imagen;
        this.id = id;
        this.api = api;
    }

    public long getId() {
        return id;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public String getApi() {
        return api;
    }
}