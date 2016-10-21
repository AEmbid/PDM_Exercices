package com.pdm.p_09_eventos_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                TextView textView = (TextView) findViewById(R.id.textView2);
                String valor1 = editText1.getText().toString();
                String valor2 = editText2.getText().toString();
                String resultado;
                if (TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)) {
                    resultado = "Faltan datos";
                } else if (Double.parseDouble(valor2)==0) {
                    resultado = "No se puede dividir por cero";
                } else {
                    double num1 = Double.parseDouble(valor1);
                    double num2 = Double.parseDouble(valor2);
                    double divi = num1 / num2;
                    resultado = String.valueOf(divi);
                }

                textView.setText(resultado);
            }
        });
    }

}
