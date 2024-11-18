package com.example.pruebasuf21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia al botón que está en el layout
        Button boton = (Button) findViewById(R.id.button1);

        // Creación de un listener que escucha los eventos de clics en el botón
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón, se cambiará el texto del TextView
                TextView tv = (TextView) findViewById(R.id.textView); // Referencia al TextView
                tv.setText("¡Hola Mundo!"); // Cambia el texto del TextView a "¡Hola Mundo!"
            }
        };

        // Se asigna el listener al botón para que responda a los clics
        boton.setOnClickListener(listener);
    }
}


