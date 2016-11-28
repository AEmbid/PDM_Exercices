package com.pdm.p_56_fragmentos_09;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.pdm.p_56_fragmentos_09.R.array.fotos;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {


    private static final String ID_SELECCIONADO = "seleccionado";
    private int seleccionado;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle recibidos = getArguments();
        seleccionado = recibidos.getInt(ID_SELECCIONADO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getResources().getStringArray(R.array.descripciones)[seleccionado]);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().obtainTypedArray(fotos).getDrawable(seleccionado));
        return view;
    }

}
