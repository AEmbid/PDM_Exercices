package com.pdm.p_13_eventos_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btne_d = (Button) findViewById(R.id.button);
        Button btnd_e = (Button) findViewById(R.id.button2);
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    finish();
                }
            });

        btnd_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dol = (EditText) findViewById(R.id.editText2);
                EditText eur = (EditText) findViewById(R.id.editText);

                String dola = dol.getText().toString();

                if (TextUtils.isEmpty(dola)) {
                    Toast.makeText(v.getContext(), "Error: introduce un número", Toast.LENGTH_SHORT).show();

                } else {
                    double euro = Double.parseDouble(dola)*0.9187;
                    eur.setText(String.valueOf(euro));
                }

            }
        });

        btne_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dol = (EditText) findViewById(R.id.editText2);
                EditText eur = (EditText) findViewById(R.id.editText);

                String euro = eur.getText().toString();

                if (TextUtils.isEmpty(euro)) {
                    Toast.makeText(v.getContext(), "Error: introduce un número", Toast.LENGTH_SHORT).show();
                } else {
                    double dola = Double.parseDouble(euro)/0.9187;
                    dol.setText(String.valueOf(dola));
                }

            }
        });

    }

    @Override
    public void finish() {
        super.finish();
    }

    public void eurtodol() {
        double a;
    }

    public void doltoeur() {

    }
}
