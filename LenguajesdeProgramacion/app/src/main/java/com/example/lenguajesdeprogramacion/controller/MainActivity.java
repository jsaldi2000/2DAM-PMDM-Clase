package com.example.lenguajesdeprogramacion.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.lenguajesdeprogramacion.R;  // Importa el R de tu paquete

public class MainActivity extends AppCompatActivity {

    // Array de lenguajes de programación
    private String[] lenguajes = {"Java", "Python", "C++", "JavaScript", "Kotlin"};
    // Array de descripciones de los lenguajes
    private String[] descripciones = {
            "Java es un lenguaje de programación orientado a objetos utilizado para desarrollar aplicaciones multiplataforma.",
            "Python es un lenguaje de programación interpretado, fácil de aprender, utilizado en ciencia de datos, IA y desarrollo web.",
            "C++ es un lenguaje de propósito general que combina características de alto y bajo nivel, ideal para sistemas y juegos.",
            "JavaScript es el lenguaje de programación del navegador, utilizado para crear aplicaciones web interactivas.",
            "Kotlin es un lenguaje moderno que se utiliza principalmente para el desarrollo de aplicaciones Android."
    };

    private int currentIndex = 0;  // Índice para controlar qué lenguaje mostrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los elementos de la vista con el código Java
        TextView tvLenguaje = findViewById(R.id.tvLenguaje);
        Button btnVerOtroLenguaje = findViewById(R.id.btnVerOtroLenguaje);
        Button btnVerDescripcion = findViewById(R.id.btnVerDescripcion);

        // Configurar el listener del botón para cambiar de lenguaje
        btnVerOtroLenguaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar el lenguaje al siguiente en la lista
                currentIndex = (currentIndex + 1) % lenguajes.length;
                tvLenguaje.setText(lenguajes[currentIndex]);
            }
        });

        // Configurar el listener del botón para mostrar la descripción del lenguaje
        btnVerDescripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar la descripción del lenguaje actual
                String descripcion = descripciones[currentIndex];
                tvLenguaje.setText(lenguajes[currentIndex] + ": " + descripcion);
            }
        });
    }
}
