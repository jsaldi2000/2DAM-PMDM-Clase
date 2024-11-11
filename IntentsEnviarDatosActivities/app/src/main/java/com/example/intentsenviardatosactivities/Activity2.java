package com.example.intentsenviardatosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEdad;
    private TextView tvCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNombre = findViewById(R.id.tvNombre);
        tvEdad = findViewById(R.id.tvEdad);
        tvCorreo = findViewById(R.id.tvCorreo);

        // Recibir los datos del Intent
        Intent intent = getIntent();

        // Usamos los datos
        String nombre = intent.getStringExtra("Nombre");
        tvNombre.setText("Bienvenido, " + nombre);

        int edad = intent.getIntExtra("Edad", 0);
        tvEdad.setText("Tu edad es " + edad);

        String correo = intent.getStringExtra("Correo");
        tvCorreo.setText("Tu correo es " + correo);


    }
}