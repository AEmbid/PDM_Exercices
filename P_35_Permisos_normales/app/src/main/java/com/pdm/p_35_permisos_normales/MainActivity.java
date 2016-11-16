package com.pdm.p_35_permisos_normales;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Resources res = getResources();
            Button[] boton = new Button[3];
            for (int i = 0; i < 3; i++) {
                int contador = i + 1;
                String b = "button" + contador;
                boton[i] = (Button) findViewById(res.getIdentifier(b, "id", getPackageName()));
                boton[i].setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.button1:
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.iespabloserrano.net"));
                    break;
                case R.id.button2:
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:41.644225, -0.863914?z=17"));
                    break;
                case R.id.button3:
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bsoler@iesps.org"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "asunto de prueba");
                    intent.putExtra(Intent.EXTRA_TEXT, "probando el envío");
                    break;
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
}
