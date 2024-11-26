package com.example.enbuscadelintentperdidoclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asigno el Edit Text al xml
        etNombre = findViewById(R.id.etNombre);
    }

    public void comenzar(View view){
        String nombre = etNombre.getText().toString();

        if (nombre.isEmpty() || nombre.trim().equals("")){
            Toast.makeText(this, R.string.msg_no_name, Toast.LENGTH_SHORT).show();
        } else {
            // Si el usuario ha introducido el nombre, lanzo el intent
            Intent i = new Intent(this, Activity2.class);

            // Guardar el nombre introducido en "nombre" mediante la clase ClaseApplicationNombre
            ((ClaseApplicationNombre) getApplicationContext()).setNombre(nombre);

            // Inicia intent
            startActivity(i);
        }
    }
}