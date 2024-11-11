package com.example.intentsenviardatosobjetosparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.intentsenviardatosobjetosparcelable.model.Persona;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recoger el objeto Persona enviado desde MainActivity
        Persona persona = getIntent().getParcelableExtra("Persona");

        // Mostrar los datos del objeto Persona en un TextView
        TextView tvDetallesPersona = findViewById(R.id.tvDetallesPersona);
        if (persona != null) {
            tvDetallesPersona.setText("Nombre: " + persona.getNombre() + "\nEdad: " + persona.getEdad());
        }


    }

}