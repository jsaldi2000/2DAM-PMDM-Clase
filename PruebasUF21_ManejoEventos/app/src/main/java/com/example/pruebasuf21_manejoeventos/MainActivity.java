package com.example.pruebasuf21_manejoeventos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón para navegar a la actividad Vistas
        Button btnVistas = findViewById(R.id.btnVistas);

        btnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVistas = new Intent(MainActivity.this, VistasActivity.class);
                startActivity(intentVistas);
            }
        });

        // Botón para navegar a Layouts
        Button btnLayouts = findViewById(R.id.btnLayouts);

        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLayouts = new Intent(MainActivity.this, LayoutsActivity.class);
                startActivity(intentLayouts);
            }
        });

        // Botón para navegar a Eventos
        Button btnEventos = findViewById(R.id.btnEventos);

        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEventos = new Intent(MainActivity.this, EventosActivity.class);
                startActivity(intentEventos);
            }
        });

        // Botón para navegar a Toasts
        Button btnToasts = findViewById(R.id.btnToasts);

        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToasts = new Intent(MainActivity.this, ToastsActivity.class);
                startActivity(intentToasts);
            }
        });


        // Formas de crear alertas o mensajes al usuario
        // 1. TOAST NORMAL
        // Toast.makeText(getApplicationContext(),"Elige una opción", Toast.LENGTH_LONG).show();

        // 2. MENSAJE DE ALERTA EN VENTANA MODAL
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Elige una opción");
        builder.setMessage("Debes elegir una de las opciones disponibles");

        // Mostrar diálogo
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}