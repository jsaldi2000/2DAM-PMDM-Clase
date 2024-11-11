package com.example.intentsenviardatosobjetosparcelabla;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import android.os.Bundle;

import com.example.intentsenviardatosobjetosparcelabla.model.Persona;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // recoger el objeto de Persona enviado desde MainActivity
        Persona persona = getIntent().getParcelableExtra("Persona");

        // Mostrar los datos del objeto recibido
        TextView tvDetallesPersona = findViewById(R.id.tvDetallesPersona);
        if (persona != null) {
            tvDetallesPersona.setText("Nombre: " + persona.getNombre() + "\nEdad: " + persona.getEdad());
        }
    }
}