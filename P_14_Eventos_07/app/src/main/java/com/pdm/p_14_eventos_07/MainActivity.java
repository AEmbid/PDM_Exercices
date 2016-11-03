package com.pdm.p_14_eventos_07;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import static com.pdm.p_14_eventos_07.R.id.pengu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button more = (Button) findViewById(R.id.btmore);
        Button less = (Button) findViewById(R.id.btless);

        more.setOnClickListener(this);
        less.setOnClickListener(this);

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RelativeLayout fondo = (RelativeLayout) findViewById(R.id.activity_main);
                        int color;
                        if (checkedId == R.id.rdcolor) {
                            color = ContextCompat.getColor(getApplicationContext(), R.color.miverde);
                        } else {
                            color = Color.WHITE;
                        }
                        fondo.setBackgroundColor(color);
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        ImageView peng = (ImageView) findViewById(R.id.pengu);
        switch (v.getId()) {
            case R.id.btmore:
                peng.setImageAlpha(0);
                break;
            case R.id.btless:
                peng.setImageAlpha(255);
                break;
            default:
                break;
        }
    }
}
