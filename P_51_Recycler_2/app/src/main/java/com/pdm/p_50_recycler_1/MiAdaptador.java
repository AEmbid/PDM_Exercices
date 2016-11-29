package com.pdm.p_50_recycler_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    private ArrayList<Item> datos;
    private MiOnItemClickListener listener;

    interface MiOnItemClickListener {
        void miOnItemClick(int botonClickado, int posicionItem);
    }

    MiAdaptador(ArrayList<Item> datos, MiOnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }


    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        String texto = datos.get(position).getTexto();
        holder.textView.setText(texto);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    class MiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button borrar, bajar, copiar;
        TextView textView;

        MiViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            borrar = (Button) itemView.findViewById(R.id.button);
            bajar = (Button) itemView.findViewById(R.id.button2);
            copiar = (Button) itemView.findViewById(R.id.button3);
            borrar.setOnClickListener(this);
            bajar.setOnClickListener(this);
            copiar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.miOnItemClick(v.getId(), getLayoutPosition());
        }
    }

}
