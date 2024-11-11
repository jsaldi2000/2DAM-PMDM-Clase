package com.example.intentsenviardatosactivitiesbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private TextView tvNombreRecibido;
    private TextView tvEdadRecibida;
    private ListView lvListaRecibida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNombreRecibido = findViewById(R.id.tvNombreRecibido);
        tvEdadRecibida = findViewById(R.id.tvEdadRecibida);
        lvListaRecibida = findViewById(R.id.lvListaRecibida);

        // Recibir los datos del Intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // Usamos los datos
        if (extras != null) {
            String nombre = extras.getString("Nombre");
            String edad = extras.getString("Edad");
            ArrayList<String> lista = extras.getStringArrayList("Lista");

            tvNombreRecibido.setText("Bienvenido " + nombre);
            tvEdadRecibida.setText("Edad: " + edad);

            // Adaptador para mostrar la lista en el ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            lvListaRecibida.setAdapter(adapter);
        }
    }
}


