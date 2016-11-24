package com.pdm.p_44_toolbar_pestanas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BlankFragment extends Fragment {
    private static final String ARG_NUM_TAB = "numTab";

    private String mNumTab;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NUM_TAB, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNumTab = getArguments().getString(ARG_NUM_TAB);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        switch (mNumTab) {
            case "Zaragoza":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.zaragoza));
                break;
            case "Huesca":
                textView.setText(getString(R.string.texto));
                break;
            case "Teruel":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.jamon));
                break;
            default:
                break;
        }

        return view;
    }

}
