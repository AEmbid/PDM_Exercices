package com.pdm.p_42_fragmentos_05;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {
    private static final String ID_CLAVE = "chequeado";
    private int seleccionado;
    private Context contexto;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        contexto=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle recibidos=getArguments();
        seleccionado=recibidos.getInt(ID_CLAVE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detalle, container, false);
        String texto=null;
        Drawable imagen=null;
        switch (seleccionado){
            case R.id.radioButton:
                texto=getString(R.string.z);
                imagen= ContextCompat.getDrawable(contexto,R.drawable.zaragoza);
                break;
            case R.id.radioButton2:
                texto=getString(R.string.h);
                imagen= ContextCompat.getDrawable(contexto,R.drawable.huesca);
                break;
            case R.id.radioButton3:
                texto=getString(R.string.t);
                imagen= ContextCompat.getDrawable(contexto,R.drawable.teruel);
                break;
        }
        TextView textView=(TextView)view.findViewById(R.id.textView);
        textView.setText(texto);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        imageView.setImageDrawable(imagen);
        return view;
    }

}
