package com.pdm.p_36_permisos_peligrosos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View vista;
    private static final int SOLICITUD_PERMISO_LLAMADA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vista = findViewById(R.id.activity_main);
        // ¿Tengo el permiso para hacer la accion?
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            hacerLlamada();
        } else {
            pedirPermiso();
        }

    }

    private void hacerLlamada() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:976491015"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private void pedirPermiso() {
        //Este IF es necesario para saber si el usuario ha marcado o no la casilla [] No volver a preguntar
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            final Activity activity=this;
            // SnackBar que explica el motivo de la solicitud
            Snackbar.make(vista, "Sin el permiso administrar llamadas no puedo realizar llamadas.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Pedimos el permiso o los permisos con un cuadro de dialogo del sistema
                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, SOLICITUD_PERMISO_LLAMADA);
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},SOLICITUD_PERMISO_LLAMADA);
        }
    }

    //Gestionar la respuesta del usuario a la solicitud del permiso.
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        // Si tuviesemos diferentes permisos solicitando permisos de la aplicacion, aqui habria varios IF o switch
        if (requestCode == SOLICITUD_PERMISO_LLAMADA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Realizamos la accion
                hacerLlamada();
            } else {
                Snackbar.make(vista, "Sin el permiso, no puedo realizar la acción", Snackbar.LENGTH_LONG).show();
            }
        }
    }
}