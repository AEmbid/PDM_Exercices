package com.pdm.p_56_fragmentos_09;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pdm.p_56_fragmentos_09.ItemFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final OnListFragmentInteractionListener mListener;

    private final ItemFragment.MiOnLongClickListener otroListener;

    //Posición inicial seleccionada ninguna
    private int posicionSeleccionada = -1;


    public MyItemRecyclerViewAdapter(ArrayList<Item> items, OnListFragmentInteractionListener listener, ItemFragment.MiOnLongClickListener otroListener) {
        mValues = items;
        mListener = listener;
        this.otroListener = otroListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        if (posicionSeleccionada == position) {
            holder.mView.setBackgroundColor(ContextCompat.getColor(holder.mView.getContext(), R.color.colorAccent));
        } else {
            holder.mView.setBackgroundColor(Color.TRANSPARENT);
        }
         holder.mContentView.setText(mValues.get(position).getTexto());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// Actualización de posiciones nuevas y antiguas
                notifyItemChanged(posicionSeleccionada);
                posicionSeleccionada = holder.getLayoutPosition();
                notifyItemChanged(posicionSeleccionada);
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.getLayoutPosition());
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //// Actualización de posiciones nuevas y antiguas
                notifyItemChanged(posicionSeleccionada);
                posicionSeleccionada = holder.getLayoutPosition();
                notifyItemChanged(posicionSeleccionada);
                if (null != otroListener) {
                    otroListener.onMiLongClick(holder.getLayoutPosition());
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
