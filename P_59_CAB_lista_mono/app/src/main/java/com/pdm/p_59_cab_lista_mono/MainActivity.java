package com.pdm.p_59_cab_lista_mono;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, android.view.ActionMode.Callback {

    private static final String ID_SELECCIONADO = "seleccionado";
    private boolean dosFragmentos;
    private ActionMode miActionMode;
    private Item itemSeleccionado;

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
        if (findViewById(R.id.content_detalle) != null)
            dosFragmentos = true;

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

    @Override
    public void onListFragmentInteraction(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(ID_SELECCIONADO, id);
        if (dosFragmentos) {
            DetalleFragment detalleFragment = new DetalleFragment();
            detalleFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_detalle, detalleFragment).commit();
        } else {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override
    public void ponerActionMode(Item item) {
        this.itemSeleccionado = item;
        if (miActionMode == null) {
            miActionMode = startActionMode(this);
        }
    }


    @Override
    public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
        mode.setTitle(itemSeleccionado.getTexto());
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_cab, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Seleccionado: " + itemSeleccionado.getTexto(), Toast.LENGTH_SHORT).show();
                mode.finish();
                itemSeleccionado = null;
                return true;
            case R.id.item2:
                int seleccionado = 0;
                if (itemSeleccionado.getTexto().contentEquals("Huesca"))
                    seleccionado = 1;
                else {
                    if (itemSeleccionado.getTexto().contentEquals("Teruel"))
                        seleccionado = 2;
                }
                Bundle bundle = new Bundle();
                bundle.putInt(ID_SELECCIONADO, seleccionado);
                if (dosFragmentos) {
                    NavegacionFragment navegacionFragment = new NavegacionFragment();
                    navegacionFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_detalle, navegacionFragment).commit();
                } else {
                    Intent intent = new Intent(this, NavegacionActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                mode.finish();
                itemSeleccionado = null;
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(android.view.ActionMode mode) {
        miActionMode = null;
    }
}
