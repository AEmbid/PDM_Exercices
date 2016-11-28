package com.pdm.p_62_menu_02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    private final ArrayList<Item> datosLista;
    private final Context applicationContext;
    private String ciudadEscogida;

    public MiAdaptador(ArrayList<Item> datosLista, Context applicationContext) {
        this.datosLista = datosLista;
        this.applicationContext = applicationContext;
    }

    @Override
    public MiAdaptador.MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,
                parent, false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiAdaptador.MiViewHolder holder, int position) {
        String texto = datosLista.get(position).getTexto();
        holder.textView.setText(texto);
    }

    @Override
    public int getItemCount() {
        return datosLista.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MiViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int itemEscogido = getLayoutPosition();
                    ciudadEscogida = applicationContext.getResources().getStringArray(R.array.ciudades)[itemEscogido];
                    PopupMenu popup = new PopupMenu(view.getContext(), view);
                    popup.inflate(R.menu.menu_popup);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            Intent intent = new Intent(applicationContext, SegundaActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("enviado", ciudadEscogida + " " + item.getTitle());
                            intent.putExtras(bundle);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            applicationContext.startActivity(intent);
                            return true;
                        }
                    });
                    popup.show();
                    return true;
                }
            });
        }
    }
}
