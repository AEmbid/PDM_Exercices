package com.pdm.p_33_intents_implicitos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.provider.LiveFolders.INTENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String who = "976491015";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button call = (Button) findViewById(R.id.button);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent llamada = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", who, null));
        startActivity(llamada);
    }
}
