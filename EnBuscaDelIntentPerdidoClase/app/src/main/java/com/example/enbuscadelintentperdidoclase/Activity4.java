package com.example.enbuscadelintentperdidoclase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    // Inicializamos componentes y variable llaves que determinará si se ha cogido o no la llave
    TextView tvTexto;
    boolean llaves = false;

    // Gestionar el resultado de la actividad Activity5 a través de un ActivityResultLauncher, que se utiliza para coger la llave
    private ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        tvTexto = findViewById(R.id.tvInfoLlaves);
        String nombre = ((ClaseApplicationNombre) getApplicationContext()).getNombre();
        tvTexto.setText(String.format(getString(R.string.bienvenida4), nombre));

        // Configuramos el launcher de la actividad Activity5 para mostrar un toast y cambiar la variable llaves a true
        startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    // RESULT_OK, pondré la variable llaves a true y lanzo el Toast infomrando al jugador
                    if (result.getResultCode() == RESULT_OK){
                        llaves = true;
                        Toast.makeText(Activity4.this, R.string.conLlave, Toast.LENGTH_SHORT).show();
                    // RESULT_CANCELED, no cambio llaves, y lanzo el Toast
                    } else {
                        Toast.makeText(Activity4.this, R.string.sinLlave, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    // Método asociado al botón "Coge la llave primero", que lanzará el ActivityForResult
    public void cogerLlave(View view){
        if(!llaves){
            Intent i = new Intent(this, Activity5.class);
            startActivityForResult.launch(i);
        }
    }

    public void abrirPuerta(View view){
        if (llaves){
            Intent i = new Intent(this, Activity6.class);
            startActivity(i);
        } else {
            Toast.makeText(this,R.string.toastLlaves, Toast.LENGTH_LONG).show();
        }
    }


}