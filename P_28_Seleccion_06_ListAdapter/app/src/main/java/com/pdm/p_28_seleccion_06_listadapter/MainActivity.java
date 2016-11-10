package com.pdm.p_28_seleccion_06_listadapter;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.res);
        ListView listView = (ListView) findViewById(android.R.id.list);
        String[] asignaturas= getResources().getStringArray(R.array.opciones);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asignaturas);
        listView.setAdapter(adapter);
    }
        /*
        Método encargado de detectar una pulsación sobre un elemento del ListActivity. Los parámetros son:
            l: El ListView donde ocurrió el click
            v: La vista (View) que fue pulsada
            position: La posición de la vista en la lista
            id: El identificador de la fila del ítem que fue pulsado
        */
        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            String[] cursos= getResources().getStringArray(R.array.cursos);
            textView.setText(l.getItemAtPosition(position) + " es de " + cursos[position]);
        }
}

