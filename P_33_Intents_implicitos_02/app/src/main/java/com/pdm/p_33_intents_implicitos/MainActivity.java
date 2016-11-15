package com.pdm.p_33_intents_implicitos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.provider.LiveFolders.INTENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phon = (TextView) findViewById(R.id.phonenum);

        Button call = (Button) findViewById(R.id.button);
        call.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
