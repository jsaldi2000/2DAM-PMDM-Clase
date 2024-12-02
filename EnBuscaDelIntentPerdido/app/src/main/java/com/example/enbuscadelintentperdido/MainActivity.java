package com.example.enbuscadelintentperdido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //static final String CLAVE_NOMBRE = "NOMBRE";
    EditText etNombre;
    Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnComenzar = findViewById(R.id.btnComienzo);
    }

    public void comenzar(View view) {
        String nombre = etNombre.getText().toString();

        if (nombre.isEmpty() || nombre.trim().equals("")) {
            Toast.makeText(this, R.string.msg_no_name, Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(this, Activity2.class);

            //Guardar el nombre introducido en Nombre mediante el método setNombre de la clase ClaseApplicationNombre
            ((ClaseApplicationNombre) getApplicationContext()).setNombre(nombre);

            //Inicia intent
            startActivity(i);
        }
    }
}