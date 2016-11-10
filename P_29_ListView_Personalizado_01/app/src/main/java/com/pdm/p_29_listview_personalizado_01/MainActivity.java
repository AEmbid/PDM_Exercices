package com.pdm.p_29_listview_personalizado_01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView versions = (ListView) findViewById(android.R.id.list);

        String[] resource = getResources().getStringArray(R.array.codenames);

        ListAdapter la = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resource);

        versions.setAdapter(la);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String ver = getResources().getStringArray(R.array.codenames)[position].toString();
        String api = getResources().getStringArray(R.array.apilevel)[position].toString();

        Toast.makeText(this, ver+" "+api, Toast.LENGTH_SHORT).show();

    }
}
