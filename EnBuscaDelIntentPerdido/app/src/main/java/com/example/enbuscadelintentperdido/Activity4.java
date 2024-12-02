package com.example.enbuscadelintentperdido;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    // Inicializamos componentes necesarios y variable llaves que determinará si la llave se ha cogido o no
    TextView tvTexto;
    boolean llaves = false;

    //Gestiona el resultado de la actividad Activity5, que se utiliza para recoger la llave.
    private ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // Rellenamos el TextView tvTexto que da la bienvenida al jugador
        tvTexto = findViewById(R.id.tvInfoLlaves);
        String nombre = ((ClaseApplicationNombre) getApplicationContext()).getNombre(); // Recojo el nombre guardado al inicio
        tvTexto.setText(String.format(getString(R.string.bienvenida4), nombre));

        // Configurar el lanzador de la actividad Activity5 para mostrar el toast correcto y cambiar la variable llaves a true
        startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    // RESULT_OK, pone llaves a true y lanza el Toast
                    if (result.getResultCode() == RESULT_OK) {
                        llaves = true;
                        Toast.makeText(Activity4.this, R.string.conLlave, Toast.LENGTH_LONG).show();

                    // RESULT_CANCELED, pone llaves a true y lanza el Toast
                    } else {
                        Toast.makeText(Activity4.this, R.string.sinLlave, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    // Método asociado al botón "Coge la llave primero", que lanzará el ActivityForResult
    public void cogerLlave(View view) {
        if (!llaves) {
            Intent i = new Intent(this, Activity5.class);
            startActivityForResult.launch(i);
        }
    }

    // Método asociado a "Abre la puerta", 1) Si se recoge la llave (RESULT_OK) llave= true y va a Activity6, 2) si no al abrirPuerta le saldrá un Toast que necesita llaves.
    public void abrirPuerta(View view) {
        if (llaves) {
            Intent i = new Intent(this, Activity6.class);
            startActivity(i);
        } else {
            Toast.makeText(this, R.string.toastLlaves, Toast.LENGTH_LONG).show();
        }
    }
}
