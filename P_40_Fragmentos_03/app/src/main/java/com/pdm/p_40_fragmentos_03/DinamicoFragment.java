package com.pdm.p_40_fragmentos_03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DinamicoFragment extends Fragment {


    public DinamicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dinamico, container, false);
        final Switch aSwitch= (Switch) view.findViewById(R.id.switch1);
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dinamicoLayout);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (aSwitch.isChecked())
                    frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                else
                    frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }
        });
        return view;
    }

}
