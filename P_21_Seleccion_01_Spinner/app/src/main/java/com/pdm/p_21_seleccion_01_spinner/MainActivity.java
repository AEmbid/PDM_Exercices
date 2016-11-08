package com.pdm.p_21_seleccion_01_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView= (TextView)findViewById(R.id.textView2) ;
        String []opcion={"BD","XML","Android"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, opcion);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] cursos = { "1º", "1º", "2º" };
                String resu = "El curso de " + parent.getItemAtPosition(position) + " es " + cursos[position];
                textView.setText(resu);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("Escoja asignatura");
            }
        });
    }
}
