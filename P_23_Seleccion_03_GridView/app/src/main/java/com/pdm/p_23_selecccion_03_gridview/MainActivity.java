package com.pdm.p_23_selecccion_03_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.textView2);
        String[] datos = new String[50];
        for(int i=1; i<=50; i++)
            datos[i-1] = "Dato "+String.valueOf(i);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, android.view.View v, int position, long id) {
                        textView.setText("Opción seleccionada: " + parent.getItemAtPosition(position));
                    }
                });
    }
}
