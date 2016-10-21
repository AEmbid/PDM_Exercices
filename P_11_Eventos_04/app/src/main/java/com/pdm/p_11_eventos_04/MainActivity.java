package com.pdm.p_11_eventos_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                TextView textView = (TextView) findViewById(R.id.textView2);
                String valor1 = editText1.getText().toString();
                double num1 = Double.parseDouble(valor1);
                String valor2 = editText2.getText().toString();
                double num2 = Double.parseDouble(valor2);
                String resultado;
                if (isChecked) {
                    double operacion = num1 - num2;
                    resultado = String.valueOf(operacion);
                } else
                    resultado = "Active CheckBox para ver resultado";
                textView.setText(resultado);
            }
        });
    }
}
