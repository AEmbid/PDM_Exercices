package com.pdm.p_82_ficheros_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_read, bt_write;
    EditText et_nomfile;

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

        et_nomfile = (EditText) findViewById(R.id.et_namefile);

        bt_write = (Button) findViewById(R.id.btn_escribir);
        bt_read = (Button) findViewById(R.id.btn_leer);

        bt_read.setOnClickListener(this);
        bt_write.setOnClickListener(this);
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
    public void onClick(View view) {
        Intent i = null;
        Bundle b = new Bundle();
        b.putString("filename", et_nomfile.getText().toString());
        switch (view.getId()) {
            case R.id.btn_escribir:
                i = new Intent(this, EscribirActivity.class);
                break;
            case R.id.btn_leer:
                i = new Intent(this, LeerActivity.class);
                break;
        }
        i.putExtras(b);
        startActivity(i);
    }
}
