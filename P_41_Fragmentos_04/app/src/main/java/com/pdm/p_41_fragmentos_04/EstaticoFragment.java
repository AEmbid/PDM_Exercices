package com.pdm.p_41_fragmentos_04;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class EstaticoFragment extends Fragment {

    OnBotonTocadoListener listener;
    public interface OnBotonTocadoListener {
        void onBotonTocado(int color);
    }

    public EstaticoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estatico, container, false);
        final ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
        try {
            listener = (OnBotonTocadoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " falta implementar listener");
        }

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorNuevo;
                if (toggleButton.isChecked())
                    colorNuevo = R.color.colorPrimary;
                else
                    colorNuevo = R.color.colorAccent;
                listener.onBotonTocado(colorNuevo);
            }
        });
        return view;
    }

}
