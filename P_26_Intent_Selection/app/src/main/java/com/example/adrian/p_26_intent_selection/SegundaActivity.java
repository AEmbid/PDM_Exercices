package com.example.adrian.p_26_intent_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Bundle recibido = getIntent().getExtras();
        final String[] option;
        String title = "Asignaturas de ";

        switch (recibido.getInt("curso")) {
            case 1:
                title += "1º";
                option = getResources().getStringArray(R.array.opciones1);
                break;
            case 2:
                title += "2º";
                option = getResources().getStringArray(R.array.opciones2);
                break;
            default:
                option = new String[0];
                break;
        }

        TextView tit = (TextView) findViewById(R.id.title2);
        tit.setText(title);


        ArrayAdapter<String> asig = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option);
        final ListView as  = (ListView) findViewById(R.id.as);
        as.setAdapter(asig);

        as.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(view.getContext(), TerceraActivity.class);
                intent.putExtra("curso", recibido.getInt("curso")+"º");
                intent.putExtra("asignatura", option[pos]);
                startActivity(intent);
            }
        });

    }

}
