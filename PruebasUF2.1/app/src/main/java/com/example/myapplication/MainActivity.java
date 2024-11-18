package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonClick(View view) {

        // Aquí puedes poner la lógica que quieras ejecutar cuando el botón sea pulsado
        Toast.makeText(this, "¡Botón clicado!", Toast.LENGTH_SHORT).show();

    }

    public void onCheckBoxClicked(View view) {

        // Aquí puedes poner la lógica que quieras ejecutar cuando el checkbox sea pulsado
        Toast toast2 = new Toast.makeText(this, "¡CheckBox seleccionado!", Toast.LENGTH_SHORT).show();
        toast2.setGravity(Gravity.CENTER, 0, 0);
    }
}