package com.example.fragmentosdinamicosejemploperros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionPerroActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_perro);

        // Contenedor para botones dinámicos
        LinearLayout layout = findViewById(R.id.layoutButtons);

        // Inicializa una nueva instancia de la clase donde tenemos los datos de los perros
        PerrosDatos perrosDatos = new PerrosDatos();

        // Crear botones dinámicos para cada perro
        for (Perro perro : perrosDatos.getNombrePerros()) {

            // Crear un botón dinámico para cada perro
            Button btnPerro = new Button(this);
            btnPerro.setText(perro.getNombre());

            // Añadir el botón al layout
            layout.addView(btnPerro);

            // Listener para enviar el nombre del perro seleccionado como resultado
            btnPerro.setOnClickListener(v -> {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nombrePerro", perro.getNombre());
                setResult(RESULT_OK, resultIntent); // Configura el resultado de la actividad
                finish(); // Finaliza la actividad y vuelve
            });
        }
    }

    // Método que se ejecuta cuando se presiona el botón cancelar
    public void cancelar(View view) {
        setResult(RESULT_CANCELED); // Configura el resultado como cancelado
        finish(); // Finaliza la actividad
    }
}
