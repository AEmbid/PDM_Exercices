package com.pdm.p_12_eventos_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton toggleButton;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        textView = (TextView) findViewById(R.id.textView2);
        toggleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (toggleButton.isChecked())
            textView.setText("ToogleButton ON");
        else
            textView.setText("ToogleButton OFF");

    }
}
