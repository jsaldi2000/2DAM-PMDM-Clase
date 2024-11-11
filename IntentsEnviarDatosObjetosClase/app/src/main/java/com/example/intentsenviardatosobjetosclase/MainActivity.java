package com.example.intentsenviardatosobjetosclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intentsenviardatosobjetosclase.model.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarDatos(View view) {

        // Crear una instancia de persona
        Persona persona = new Persona("Juan Pérez", 25);

        // Creamos un intent para iniciar Activity2, y enviar el objeto persona
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Persona", persona);
        startActivity(intent);

    }
}