package com.pdm.p_82_ficheros_1;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class EscribirActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_guardar, bt_clear;
    EditText et_contenido;
    TextView tv_titulo;
    String nombrearchivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt_guardar = (Button) findViewById(R.id.btn_save);
        bt_clear = (Button) findViewById(R.id.btn_reset);

        et_contenido = (EditText) findViewById(R.id.et_content);

        tv_titulo = (TextView) findViewById(R.id.tv_title);

        bt_clear.setOnClickListener(this);
        bt_guardar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        nombrearchivo = b.getString("filename");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reset:
                et_contenido.setText("");
                break;
            case R.id.btn_save:
                escribir();
                break;
        }
    }

    public void escribir() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(nombrearchivo, Context.MODE_PRIVATE)));
            writer.write(et_contenido.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
