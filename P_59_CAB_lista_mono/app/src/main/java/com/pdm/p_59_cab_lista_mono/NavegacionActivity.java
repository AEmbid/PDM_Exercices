package com.pdm.p_59_cab_lista_mono;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NavegacionActivity extends AppCompatActivity {
    private static final String ID_SELECCIONADO = "seleccionado";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) ==Configuration.SCREENLAYOUT_SIZE_LARGE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_navegacion);
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
        int seleccionado = bundle.getInt(ID_SELECCIONADO);
        String texto = getResources().getStringArray(R.array.ciudades)[seleccionado];
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(texto);
        }
        NavegacionFragment navegacionFragment = new NavegacionFragment();
        navegacionFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_navegacion, navegacionFragment).commit();
    }

}
