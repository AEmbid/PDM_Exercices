package com.pdm.p_22_seleccion_02_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] opcion = { "BD", "XML", "Android" };
        final TextView textView = (TextView) findViewById(R.id.textView2);
        final ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opcion);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] cursos = { "1º", "1º", "2º" };
                textView.setText(listView.getItemAtPosition(position) + " es " + cursos[position]);
            }
        });
    }
}
