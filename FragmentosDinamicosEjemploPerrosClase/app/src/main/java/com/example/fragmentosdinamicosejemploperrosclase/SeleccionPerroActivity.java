package com.example.fragmentosdinamicosejemploperrosclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View;

public class SeleccionPerroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_perro);

        // Contenedor para botones dinámicos
        LinearLayout layout = findViewById(R.id.layoutButtons);

        // Inicializar instancia donde tengo los datos de los perros
        PerrosDatos perrosDatos = new PerrosDatos();

        // Crear botones dinámicos para cada perro
        for (Perro perro : perrosDatos.getNombrePerros()){

            // Creo el botón para cada uno de los nombres
            Button btnPerro = new Button(this);
            btnPerro.setText(perro.getNombre());

            // Añado el botón creado dinámicamente al layout
            layout.addView(btnPerro);

            // Aquí voy a crear un listener para enviar el nombre del perro seleccionado como RESULTADO
            btnPerro.setOnClickListener(v -> {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nombrePerro", perro.getNombre());
                setResult(RESULT_OK, resultIntent);
                finish();
            });
        }
    }

    // Método para el botón cancelar
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}