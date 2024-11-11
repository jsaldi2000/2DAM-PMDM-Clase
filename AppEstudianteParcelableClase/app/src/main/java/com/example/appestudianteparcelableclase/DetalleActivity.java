package com.example.appestudianteparcelableclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appestudianteparcelableclase.model.Estudiante;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Recibir el objeto de Estudiante desde el intent
        Estudiante estudiante = getIntent().getParcelableExtra("Estudiante");

        // Muestro los datos del estudiante en el tvDetalles
        TextView tvDetalles = findViewById(R.id.tvDetalles);

        if (estudiante != null){
            tvDetalles.setText("Nombre: " + estudiante.getNombre() +
                    "\nEdad: " + estudiante.getEdad() +
                    "\nCurso: " + estudiante.getCurso() +
                    "\nNota Final: " + estudiante.getNotaFinal());
        }
    }
}