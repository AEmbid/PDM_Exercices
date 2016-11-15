package com.pdm.p_30_listview_personalizado_02;

import android.graphics.drawable.Drawable;

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

    public Item(long id, String api, Drawable imagen) {
        this.id = id;
        this.api = api;
        this.imagen = imagen;
    }
    public long getId() {
        return id;
    }
    public String getApi() {
        return api;
    }
    public Drawable getImagen() {
        return imagen;
    }
} 