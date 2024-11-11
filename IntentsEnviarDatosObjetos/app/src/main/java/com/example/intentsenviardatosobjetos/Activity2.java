package com.example.intentsenviardatosobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.intentsenviardatosobjetos.model.Persona;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recoger el objeto Persona enviado desde MainActivity
        Persona persona = (Persona) getIntent().getSerializableExtra("Persona");

        // Mostrar los datos del objeto Persona en un TextView
        TextView textView = findViewById(R.id.tvDetallesPersona);
        if (persona != null) {
            textView.setText("Nombre: " + persona.getNombre() + "\nEdad: " + persona.getEdad());
        }
    }
}
