package com.example.activityforresultejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityforresultejemplo.datos.DatosPersonas;

public class SeleccionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        LinearLayout layout = findViewById(R.id.layoutButtons);

        // Crear botones dinámicos para cada persona
        for (String persona : DatosPersonas.personas) {
            Button btnPersona = new Button(this);
            btnPersona.setText(persona);

            // Listener para enviar el resultado a través del intent
            btnPersona.setOnClickListener(v -> {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("PERSONA_SELECCIONADA", persona);
                setResult(RESULT_OK, resultIntent);
                finish();
            });

            //añade el botón generado dinámicamente al ConstraintLayout
            layout.addView(btnPersona);
        }

        // Botón para cancelar
        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
