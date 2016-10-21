package com.pdm.p_10_eventos_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                RadioButton radioButton=(RadioButton)findViewById(R.id.radioButton);
                TextView textView = (TextView) findViewById(R.id.textView2);
                String valor1 = editText1.getText().toString();
                double num1 = Double.parseDouble(valor1);
                String valor2 = editText2.getText().toString();
                double num2 = Double.parseDouble(valor2);
                double operacion = 0;
                if (radioButton.isChecked())
                    operacion=num1*num2;
                if (checkedId==R.id.radioButton2)
                    operacion=num1/num2;
                String resultado = String.valueOf(operacion);
                textView.setText(resultado);
            }
        });
     }
}
