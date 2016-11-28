package com.pdm.p_59_cab_lista_mono;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pdm.p_59_cab_lista_mono.ItemFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final OnListFragmentInteractionListener mListener;
    private int posicionSeleccionada = -1;

    MyItemRecyclerViewAdapter(ArrayList<Item> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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
        holder.mContentView.setText(mValues.get(position).getTexto());
        if (posicionSeleccionada == position) {
            holder.mView.setBackgroundColor(ContextCompat.getColor(holder.mView.getContext(), R.color.colorPrimary));
        } else {
            holder.mView.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    //// Actualización de posiciones nuevas y antiguas
                    notifyItemChanged(posicionSeleccionada);
                    posicionSeleccionada = holder.getLayoutPosition();
                    notifyItemChanged(posicionSeleccionada);
                    mListener.onListFragmentInteraction(holder.getLayoutPosition());
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != mListener) {
                    notifyItemChanged(posicionSeleccionada);
                    posicionSeleccionada = holder.getLayoutPosition();
                    notifyItemChanged(posicionSeleccionada);
                    mListener.ponerActionMode(holder.mItem);
                    return true;
                }
                else
                    return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mContentView;
        Item mItem;

        ViewHolder(View view) {
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
