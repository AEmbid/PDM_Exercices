package com.pdm.p_59_cab_lista_mono;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavegacionFragment extends Fragment {

    private static final String ID_SELECCIONADO = "seleccionado";
    private int seleccionado;

    public NavegacionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_navegacion, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        String url=getResources().getStringArray(R.array.web)[seleccionado];
        myWebView.loadUrl(url);
        return view;
    }

}
