package com.example.intentsenviardatosobjetosclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.intentsenviardatosobjetosclase.model.Persona;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recoger el objeto persona enviado desde MainActivity
        Persona persona = (Persona) getIntent().getSerializableExtra("Persona");

        // Mostrar los datos del objeto en el textview
        TextView textView = findViewById(R.id.tvDetallesPersona);
        if (persona != null){
            textView.setText("Nombre: " + persona.getNombre() + "\nEdad: " + persona.getEdad());

        }
    }
}