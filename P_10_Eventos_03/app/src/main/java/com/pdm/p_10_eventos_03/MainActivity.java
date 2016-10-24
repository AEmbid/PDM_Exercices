package com.pdm.p_10_eventos_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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

                TextView textView = (TextView) findViewById(R.id.textView2);

                String valor1 = editText1.getText().toString();
                String valor2 = editText2.getText().toString();

                double num1;
                double num2;

                if (TextUtils.isEmpty(valor1)) {num1=0;} else {num1 = Double.parseDouble(valor1);}
                if (TextUtils.isEmpty(valor2)) {num2=1;} else {num2 = Double.parseDouble(valor2);}

                double operacion = 0;

                if (checkedId==R.id.radioButton) {
                    operacion = num1 * num2;
                } else if (checkedId==R.id.radioButton2) {
                    operacion = num1 / num2;
                }
                String resultado = String.valueOf(operacion);
                textView.setText(resultado);
            }
        });
     }
}
