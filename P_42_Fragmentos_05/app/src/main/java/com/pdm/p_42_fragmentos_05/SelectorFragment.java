package com.pdm.p_42_fragmentos_05;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectorFragment extends Fragment {

    public SelectorFragment() {
        // Required empty public constructor
    }
    public interface OnCambiosListener{
        void onCambios(int seleccionado);
    }

    OnCambiosListener miListener;

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        try {
            miListener = (OnCambiosListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " falta implementar listener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_selector, container, false);
        RadioGroup radiogroup=(RadioGroup) view.findViewById(R.id.radioGroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                miListener.onCambios(checkedId);
            }
        });
        return view;
    }

    @Override
    public void onDetach () {
        super.onDetach();
        miListener=null;
    }

}
