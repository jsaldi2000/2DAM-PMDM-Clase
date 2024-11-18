package com.dam.ebdip;

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

    Button btnCogerLlave;
    Button btnAbrirPuerta;
    TextView tvTexto;
    // String nombre;
    boolean llaves = false;

    //Gestiona el resultado de la actividad Activity5, que se utiliza para intentar recoger la llave.
    private ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        tvTexto = findViewById(R.id.tvInfoLlaves);
        String nombre = ((EBDIPApplication) getApplicationContext()).getNombre();
        tvTexto.setText(String.format(getString(R.string.bienvenida4),
                nombre));
        btnCogerLlave = findViewById(R.id.btnCogerLlave);
        btnAbrirPuerta = findViewById(R.id.btnAbrirPuerta);


        // Configurar el lanzador de la actividad Activity5 para mostrar el toast correcto y cambiar la variable llaves a true
        startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        llaves = true;
                        Toast.makeText(Activity4.this, R.string.conLlave, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Activity4.this, R.string.sinLlave, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void cogerLlave(View view) {
        if (!llaves) {
            Intent i = new Intent(this, Activity5.class);
            startActivityForResult.launch(i);
        } else {
            Toast.makeText(this, getString(R.string.conLlave), Toast.LENGTH_LONG).show();
        }

    }

    public void abrirPuerta(View view) {
        if (llaves){
            Intent i= new Intent(this, Activity6.class);
            startActivity(i);
        } else {
            Toast.makeText(this, R.string.toastLlaves, Toast.LENGTH_LONG).show();
        }
    }


}