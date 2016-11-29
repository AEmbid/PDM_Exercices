package com.pdm.p_30_listview_personalizado_02;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Accedemos a los arrays de string y drawable
        final Resources resources = getResources();
        final String[] num_api =resources.getStringArray(R.array.num_api);
        TypedArray logos = resources.obtainTypedArray(R.array.logos);
        /*
        * Construimos la lista de nuestro adapter asociando cada item
        * con su número de api y su imagen
        */
        ArrayList<Item> lista = new ArrayList<>();
        for (int i=0;i<5;i++){
            lista.add(new Item(i+1, num_api[i], logos.getDrawable(i)));
        }
        logos.recycle();
        ListView listView = (ListView) findViewById(R.id.listView);
        MiAdapter miAdapter = new MiAdapter(this, lista);
        listView.setAdapter(miAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] version =resources.getStringArray(R.array.version);
                Toast.makeText(getApplicationContext(),num_api[position]+" es "+version[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
