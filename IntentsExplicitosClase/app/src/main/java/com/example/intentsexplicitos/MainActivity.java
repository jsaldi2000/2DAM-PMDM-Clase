package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Declar los componentes
    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos a la vista
        etNombre = findViewById(R.id.etNombre);

    }

    public void enviarDatos (View view){
        String nombre = etNombre.getText().toString();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Nombre", nombre);
        startActivity(intent);
    }


    }
