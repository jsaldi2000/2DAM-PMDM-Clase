package com.example.pruebasuf21_clase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
                Intent intent = new Intent(MainActivity.this, VistasActivity.class);
                startActivity(intent);
            }
        });

        // Botón para navegar a la actividad Layouts
        Button btnLayouts = findViewById(R.id.btnLayouts);
        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutsActivity.class);
                startActivity(intent);
            }
        });

        // Botón para navegar a la actividad Eventos
        Button btnEventos = findViewById(R.id.btnEventos);
        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventosActivity.class);
                startActivity(intent);
            }
        });

        // Botón para navegar a la actividad Toasts
        Button btnToasts = findViewById(R.id.btnToasts);
        btnToasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToastsActivity.class);
                startActivity(intent);
            }
        });

        // Botón para navegar a la actividad Intents
        Button btnIntents = findViewById(R.id.btnIntents);
        btnIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentsActivity.class);
                startActivity(intent);
            }
        });


        // Mostrar mensajes, 2 métodos

        // 1. TOAST NORMAL
        //Toast.makeText(getApplicationContext(), "Elige una opción", Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "De la pantalla", Toast.LENGTH_SHORT).show();

        // 2. TOAST EN VENTANA DE DIÁLOGO FLOTANTE
        // Crear el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Elige una opción");
        builder.setMessage("Debes elegir una de las opciones disponibles");

        // Mostrar el diálogo
        AlertDialog dialog = builder.create();
        dialog.show();

        // Cerrar el diálogo automáticamente después de 3 segundos
        dialog.getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 3000); // 3 segundos

    }
}
