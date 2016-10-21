package com.pdm.p_18_intent_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        String nombre= getIntent().getStringExtra("nombre");
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText("Hola "+nombre+"!. "+getString(R.string.texto3));
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String resultado = "RECHAZADAS CONDICIONES";
        if (v.getId()== R.id.button2)
            resultado = "ACEPTADAS CONDICIONES";
        Intent intent = new Intent();
        intent.putExtra("resultado", resultado);
        setResult(RESULT_OK, intent);
        finish();

    }
}
