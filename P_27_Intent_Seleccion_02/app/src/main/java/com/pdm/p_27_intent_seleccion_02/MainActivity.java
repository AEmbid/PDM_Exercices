package com.pdm.p_27_intent_seleccion_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int ASI = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.cursos));
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SegundaActivity.class);
                intent.putExtra("curs", i+1);
                startActivityForResult(intent, ASI);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == ASI) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                TextView txt = (TextView) findViewById(R.id.tv);
                txt.setText(data.getExtras().getString("asignatura") + " de " + data.getExtras().getString("curso"));
            }
        }
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(null);
    }
}