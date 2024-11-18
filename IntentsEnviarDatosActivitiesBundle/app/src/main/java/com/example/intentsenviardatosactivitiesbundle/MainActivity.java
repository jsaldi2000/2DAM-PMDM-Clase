package com.example.intentsenviardatosactivitiesbundle;

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

        // Asignar los EditText
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
    }

    // Método que se ejecuta al hacer clic en el botón "Enviar Datos"
    public void enviarDatos(View view) {

        // para los strings de los edit text
        String nombre = etNombre.getText().toString();
        String edad = etEdad.getText().toString();

        // por ejemplo una lista
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");

        // Crear un Intent para ir a la segunda actividad (Actividad2)
        Intent intent = new Intent(this, Activity2.class);

        // Crear un Bundle y añadir los datos
        Bundle extras = new Bundle();
        extras.putString("Nombre", nombre);
        extras.putString("Edad", edad);
        extras.putStringArrayList("Lista", lista);

        // Añadir el ArrayList al Bundle como Serializable (explicación opcional para objetos)
        // extras.putSerializable("Lista", lista);

        // Añadir el Bundle al Intent
        intent.putExtras(extras);

        // Iniciar la nueva actividad
        startActivity(intent);
    }
}

