package com.dam.ebdip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvTexto;
    // String nombre;
    Button btnAtajoC;
    Button btnAtajoL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvTexto = findViewById(R.id.tvElegirCamino);
        // nombre = getIntent().getStringExtra(MainActivity.CLAVE_NOMBRE);
        String nombre = ((EBDIPApplication) getApplicationContext()).getNombre();

        tvTexto.setText(String.format(getString(R.string.bienvenida2),
                nombre));

        btnAtajoC = findViewById(R.id.btnAtajoCorto);
        btnAtajoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Activity4.class);
                // i.putExtra(MainActivity.CLAVE_NOMBRE, nombre);
                startActivity(i);
            }
        });
        btnAtajoL = findViewById(R.id.btnAtajoLargo);
        btnAtajoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Activity3.class);
                startActivity(i);
            }
        });
    }

}