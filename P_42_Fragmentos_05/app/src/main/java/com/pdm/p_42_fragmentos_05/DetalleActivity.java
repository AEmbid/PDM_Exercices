package com.pdm.p_42_fragmentos_05;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class DetalleActivity extends AppCompatActivity {
    private static final String ID_CLAVE = "chequeado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detalle);
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
        Bundle bundle = getIntent().getExtras();
        int datoRecibido = bundle.getInt(ID_CLAVE);
        String texto = null;
        switch (datoRecibido) {
            case R.id.radioButton:
                texto = getString(R.string.z);
                break;
            case R.id.radioButton2:
                texto = getString(R.string.h);
                break;
            case R.id.radioButton3:
                texto = getString(R.string.t);
                break;
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(texto);
        }
        DetalleFragment detalleFragment = new DetalleFragment();
        detalleFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_detalle, detalleFragment).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
