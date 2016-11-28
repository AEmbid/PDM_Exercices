package com.pdm.p_52_recycler_3;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    private final ArrayList<Item> datos;
    private MiOnItemClickListener listener;

    public interface MiOnItemClickListener {
        void miOnItemClick(int posicionItem);
    }

    public MiAdaptador(ArrayList<Item> datos,MiOnItemClickListener listener) {
        this.datos=datos;
        this.listener=listener;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        String texto=datos.get(position).getCiudad();
        holder.textView.setText(texto);
        String texto2=datos.get(position).getDescripcion();
        holder.textView2.setText(texto2);
        Drawable imagen=datos.get(position).getFoto();
        holder.imageView.setImageDrawable(imagen);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public ImageView imageView;
        public MiViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.miOnItemClick(getLayoutPosition());
                }
            });
            textView=(TextView)itemView.findViewById(R.id.textView);
            textView2=(TextView)itemView.findViewById(R.id.textView2);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
