package com.pdm.p_40_fragmentos_03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class EstaticoFragment extends Fragment {


    public EstaticoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estatico, container, false);
        final ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.estaticoLayout);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked())
                    frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                else
                    frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }
        });
        return view;
    }

}
