package com.example.intentsenviardatosactivitiesbundleclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos componentes a la vista
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
    }

    // Método enviarDatos()
    public void enviarDatos(View view){

        String nombre = etNombre.getText().toString();
        String edad = etEdad.getText().toString();

        // añadimos una lista de elementos
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");

        // Creamos intent
        Intent intent = new Intent(this, Activity2.class);

        // Creamos un bundle y añadimos los datos a enviar
        Bundle extras = new Bundle();
        extras.putString("Nombre", nombre);
        extras.putString("Edad", edad);
        extras.putStringArrayList("Lista", lista);

        // Añadir el Bundle al Intent
        intent.putExtras(extras);

        // Iniciamos la actividad
        startActivity(intent);
    }
}