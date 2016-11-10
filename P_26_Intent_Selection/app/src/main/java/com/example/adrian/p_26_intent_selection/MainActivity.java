package com.example.adrian.p_26_intent_selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] opcion = getResources().getStringArray(R.array.cursos);
        ArrayAdapter<String> cursos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcion);

        final ListView lv = (ListView) findViewById(R.id.lv);
        final TextView tv = (TextView) findViewById(R.id.tv);

        lv.setAdapter(cursos);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intent = new Intent(view.getContext(), SegundaActivity.class);
                intent.putExtra("curso", posicion+1);
                startActivity(intent);
            }
        });
    }
}
