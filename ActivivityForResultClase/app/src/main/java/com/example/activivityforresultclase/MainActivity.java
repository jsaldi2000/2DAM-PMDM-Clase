package com.example.activivityforresultclase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaración de los componentes
    private TextView tvSelectedPersona;
    private Button btnSelectPersona;

    // Esta es la declaración de la clase que necesito para enviar datos condicionales de una activity a otra
    private ActivityResultLauncher<Intent> seleccionPersonaLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelectedPersona = findViewById(R.id.tvSelectedPersona);
        btnSelectPersona = findViewById(R.id.btnSelectPersona);

        // registrar un "contrato" para manejar el resultado de una actividad que se lanzará
        seleccionPersonaLauncher = registerForActivityResult(

                // este contrato indica que la actividad que se lanzará devuelve un resultado (RESULT_OK o RESULT_CANCELED)
                // ... junto con un intent que contiene datos adicionales
                new ActivityResultContracts.StartActivityForResult(),

                result -> {

                    // Si el código de resultado es RESULT_OK, se obtiene el intent devuelto por la actividad secundaria
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();

                        if (data != null) {
                            String selectedPersona = data.getStringExtra("PERSONA_SELECCIONADA");
                            tvSelectedPersona.setText("La persona seleccionada es: \n" + selectedPersona);
                        }

                        // Si el resultado es RESULT_CANCELED o el intent es null, se muestra un mensaje indicando que no se seleccionó ninguna persona
                    } else {
                        tvSelectedPersona.setText("No se seleccionó ninguna persona.");
                    }
                }
        );

    }

    // Configurar método y asignar al botón para lanza la actividad de selección
    public void seleccionPersona(View view) {
        Intent intent = new Intent(MainActivity.this, SeleccionActivity.class);
        seleccionPersonaLauncher.launch(intent);
    }
}