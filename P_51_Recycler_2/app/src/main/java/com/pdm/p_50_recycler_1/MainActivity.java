package com.pdm.p_50_recycler_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MiAdaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ArrayList<Item> datos = leerDatos();
        final RecyclerView recView = (RecyclerView) findViewById(R.id.recyclerView);
        recView.setHasFixedSize(true);
        LayoutManager layoutmanager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recView.setLayoutManager(layoutmanager);
        miAdaptador = new MiAdaptador(datos, new MiAdaptador.MiOnItemClickListener() {
            @Override
            public void miOnItemClick(int botonClickado, int posicionItem) {
                switch (botonClickado) {
                    case R.id.button:
                        datos.remove(posicionItem);
                        miAdaptador.notifyItemRemoved(posicionItem);
                        break;
                    case R.id.button2:
                        // si el ítem no es el último
                        if (posicionItem < recView.getChildCount() - 1) {
                            Item aux = datos.get(posicionItem);
                            datos.set(posicionItem, datos.get(posicionItem + 1));
                            datos.set(posicionItem + 1, aux);
                            miAdaptador.notifyItemMoved(posicionItem, posicionItem + 1);
                        }
                        break;
                    case R.id.button3:
                        String texto = datos.get(posicionItem).getTexto();
                        datos.add(posicionItem + 1, new Item("Copia de " + texto));
                        miAdaptador.notifyItemInserted(posicionItem + 1);
                        break;
                }
            }
        });
        recView.setAdapter(miAdaptador);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recView.setItemAnimator(itemAnimator);

    }

    private ArrayList<Item> leerDatos() {
        ArrayList<Item> datos = new ArrayList<>();
        for(int i=0; i<50; i++)
            datos.add(new Item("Texto " + i));
        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
