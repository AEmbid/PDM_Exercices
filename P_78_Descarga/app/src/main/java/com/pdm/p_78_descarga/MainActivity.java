package com.pdm.p_78_descarga;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =(ImageView)findViewById(R.id.imageView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DescargaImagenTarea().execute("http://apod.nasa.gov/apod/image/0905/m31_gendler.jpg");
            }
        });
    }

    private class DescargaImagenTarea extends AsyncTask<String, Void, Bitmap> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            imageView.setImageBitmap(null);
            progressDialog = ProgressDialog.show(MainActivity.this, "Por favor, espere", "Descargando imagen...", true);
            progressDialog.setCancelable(true);
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(url[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            imageView.setImageBitmap(result);
        }

        @Override
        protected void onCancelled() {
            imageView.setImageBitmap(null);
        }
    }
}
