package com.example.enbuscadelintentperdidoclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvTexto = findViewById(R.id.tvElegirCamino);
        String nombre = ((ClaseApplicationNombre) getApplicationContext()).getNombre();
        tvTexto.setText(String.format(getString(R.string.bienvenida2), nombre));
    }

    // Método para coger el atajo Corto
    public void atajoC(View view){
        Intent i = new Intent(Activity2.this, Activity4.class);
        startActivity(i);
    }

    // Método para coger el atajo Largo
    public void atajoL(View view){
        Intent i = new Intent(Activity2.this, Activity3.class);
        startActivity(i);
    }
}