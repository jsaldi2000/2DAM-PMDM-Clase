package com.example.pruebasuf21_clase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ToastsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasts);

        // Asignar el botón en el layout
        Button btnMostrarToast = findViewById(R.id.btnMostrarToast);

        // Configurar el evento onClick para el botón y mostrar TOAST
        btnMostrarToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar Toast
                Toast.makeText(ToastsActivity.this, "Este es un Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

