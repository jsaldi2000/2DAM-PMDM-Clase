package com.example.intentsenviardatosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Declaramos los componentes
    private EditText etNombre;
    private EditText etEdad;
    private EditText etCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos componentes a la vista
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etCorreo = findViewById(R.id.etCorreo);
    }

    public void enviarDatos (View view){
        String nombre = etNombre.getText().toString();
        int edad = Integer.parseInt(etEdad.getText().toString());
        String correo = etCorreo.getText().toString();

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Nombre", nombre);
        intent.putExtra("Edad", edad);
        intent.putExtra("Correo", correo);

        startActivity(intent);

    }
}