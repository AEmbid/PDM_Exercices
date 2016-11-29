package com.pdm.p_41_fragmentos_04;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class DinamicoFragment extends Fragment {

    OnSwitchTocadoListener listener;
    public interface OnSwitchTocadoListener {
        void onSwitchTocado(boolean chequeado);
    }


    public DinamicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dinamico, container, false);
        final Switch aSwitch= (Switch) view.findViewById(R.id.switch1);
        try {
            listener = (OnSwitchTocadoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " falta implementar listener");
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean chequeo;
                chequeo = aSwitch.isChecked();
                listener.onSwitchTocado(chequeo);
            }
        });
        return view;
    }

}
