package com.pdm.p_30_listview_personalizado_02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class MiAdapter extends BaseAdapter {
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

    MiAdapter(Activity contexto, ArrayList<Item> lista) {
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
        View view = convertView;
        ViewHolder viewHolder;
        Item item = lista.get(position);
        if (view == null) {
            LayoutInflater inflater = contexto.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nombreVersion = (TextView) view.findViewById(R.id.textView2);
            viewHolder.imagenVersion = (ImageView) view.findViewById(R.id.imageView2);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.nombreVersion.setText(item.getApi());
        viewHolder.imagenVersion.setImageDrawable(item.getImagen());
        return view;
    }

    private static class ViewHolder {
        TextView nombreVersion;
        ImageView imagenVersion;
    }

}
