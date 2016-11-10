package com.pdm.p_27_intent_seleccion_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String[] opt;

        switch (getIntent().getExtras().getInt("curs")) {
            case 1:
                opt = getResources().getStringArray(R.array.asignaturas1);
                break;
            case 2:
                opt = getResources().getStringArray(R.array.asignaturas2);
                break;
            default:
                opt = new String[0];
                break;
        }

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opt);

        ListView lva = (ListView) findViewById(R.id.lva);
        lva.setAdapter(aa);


        lva.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = getIntent();
                intent.putExtra("curso", String.valueOf(intent.getExtras().getInt("curs")) + "º");
                intent.putExtra("asignatura", adapterView.getItemAtPosition(i).toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}