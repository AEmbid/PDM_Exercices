package com.pdm.p_30_listview_personalizado_02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class miAdapter extends BaseAdapter {
    /*
    * Esta clase contiene dos atributos: de tipo Activity el primero y de tipo
    * ArrayList<ItemLista> el segundo. Ambos son pasados al constructor para
    * inicializar el adapter. El atributo Activity es necesario para poder
    * generar el layout que hemos creado anteriormente para nuestros item en el
    * ListView, El atributo ArrayList de items contiene los elementos que se
    * mostrarán.
    */

    private final Activity contexto;
    private final ArrayList<Item> lista;

    public miAdapter(Activity contexto, ArrayList<Item> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        * Debe “inflarse” el layout XML que hemos creado.
        * Esto consiste en  consultar el XML de nuestro layout y crear
        * e inicializar la estructura de objetos java equivalente. Para ello,
        * crearemos un nuevo  objeto LayoutInflater y
        * generaremos la estructura de objetos mediante su método inflate(id_layout).
        */
        LayoutInflater inflater = contexto.getLayoutInflater();
        View view = inflater.inflate(R.layout.layoutperso, null, true);

        /*
        * Una vez que la vista para el item está preparada recuperamos el ítem que
        * vamos a mostrar utilizando el segundo parámetro que recibe el método getView
        * y el ArrayList que tenemos con los items.  A continuación vamos
        * recuperando los componentes de la vista y rellenándolos con los datos adecuados.
        */
        Item item = lista.get(position);

        TextView textView = (TextView) view.findViewById(R.id.textlayout);
        textView.setText(item.getApi());

        ImageView imageView = (ImageView) view.findViewById(R.id.imglayout);
        imageView.setImageDrawable(item.getImagen());

        // Finalmente devolvemos la vista terminada de configurar.

        return view;
    }
}