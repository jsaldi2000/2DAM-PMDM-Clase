package com.example.activityforresultejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvSelectedPersona;
    private Button btnSelectPersona;
    private ActivityResultLauncher<Intent> seleccionPersonaLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelectedPersona = findViewById(R.id.tvSelectedPersona);
        btnSelectPersona = findViewById(R.id.btnSelectPersona);

        // registra un "contrato" para manejar el resultado de una actividad que se lanzará.
        seleccionPersonaLauncher = registerForActivityResult(

                //Este contrato indica que la actividad que se lanzará devuelve un resultado estándar (como RESULT_OK o RESULT_CANCELED)
                //junto con un posible Intent que contiene datos adicionales.
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    // Si el código de resultado es RESULT_OK, se obtiene el Intent devuelto por la actividad secundaria.
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String selectedPersona = data.getStringExtra("PERSONA_SELECCIONADA");
                            tvSelectedPersona.setText("La persona seleccionada es: \n" + selectedPersona);
                        }

                    // Si el resultado es RESULT_CANCELED o el Intent es null, se muestra un mensaje indicando que no se seleccionó ninguna persona.
                    } else {
                        tvSelectedPersona.setText("No se seleccionó ninguna persona.");
                    }
                }
        );
    }

    // Configurar método y asignar al botón para lanzar la actividad de selección
    public void seleccionPersona(View view) {
        Intent intent = new Intent(MainActivity.this, SeleccionActivity.class);
        seleccionPersonaLauncher.launch(intent);
    }
}
