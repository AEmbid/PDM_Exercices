package com.pdm.p19_intent_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalc = (Button) findViewById(R.id.btndo);
        Button btnhelp = (Button) findViewById(R.id.btnhelp);

        btncalc.setOnClickListener(this);
        btnhelp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText al = (EditText) findViewById(R.id.editText2);
        EditText pe = (EditText) findViewById(R.id.editText);
        switch (v.getId()) {
            case R.id.btndo:
                if (TextUtils.isEmpty(al.getText()) ||
                        TextUtils.isEmpty(pe.getText())) {
                    Toast.makeText(this, "Introduce valores", Toast.LENGTH_SHORT).show();
                }
                else if (Double.parseDouble(al.getText().toString()) == 0 ||
                        Double.parseDouble(pe.getText().toString()) == 0 ) {
                    Toast.makeText(this, "El valor '0' no es aceptado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, getData(
                            Integer.parseInt(al.getText().toString()),
                            Double.parseDouble(pe.getText().toString())
                    ), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnhelp:
                Intent showhelp = new Intent(this, SegundaActivity.class);
                startActivity(showhelp);
                break;
            default:
                //acciones para resto de botones;
        }
    }

    public String getData(int alt, double peso) {
        String helper = "Tu IMC es ";
        double al = alt;
        double n = peso / ((al/100)*(al/100));
        String h;
        if (n<18.5) {h="Bajo peso";}
        else if (n<25) {h="Tienes un peso normal";}
        else if (n<30) {h="Tienes sobrepeso";}
        else {h="Eres obeso";}

        return (helper+n+"\n"+h);
    }
}
