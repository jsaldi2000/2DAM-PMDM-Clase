package com.example.intentsenviardatosobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intentsenviardatosobjetos.model.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarDatos(View view) {

        // Crear una instancia de Persona
        Persona persona = new Persona("Juan Pérez", 25);

        // Crear un Intent para iniciar Activity2 y enviar el objeto Persona
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("Persona", persona); // Pasar el objeto Persona en el Intent
        startActivity(intent); // Iniciar Activity2

    }
}
