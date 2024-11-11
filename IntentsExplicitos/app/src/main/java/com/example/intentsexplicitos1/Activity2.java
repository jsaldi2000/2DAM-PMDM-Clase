package com.example.intentsexplicitos1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.intentsexplicitos.R;

public class Activity2 extends AppCompatActivity {

    private TextView tvPantalla2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvPantalla2 = findViewById(R.id.tvPantalla2);

        // Recibir los datos del Intent
        String nombre = getIntent().getStringExtra("Nombre");
        tvPantalla2.setText("Bienvenido " + nombre);

    }
}