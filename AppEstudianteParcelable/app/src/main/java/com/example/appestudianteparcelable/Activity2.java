package com.example.appestudianteparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appestudianteparcelable.model.Estudiante;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recibir el objeto Estudiante desde el Intent
        Estudiante estudiante = getIntent().getParcelableExtra("estudiante");

        // Mostrar los datos del estudiante en el TextView
        TextView tvDetalles = findViewById(R.id.tvDetalles);
        if (estudiante != null) {
            tvDetalles.setText("Nombre: " + estudiante.getNombre() +
                    "\nEdad: " + estudiante.getEdad() +
                    "\nCurso: " + estudiante.getCurso() +
                    "\nNota Final: " + estudiante.getNotaFinal());
        }


    }


}