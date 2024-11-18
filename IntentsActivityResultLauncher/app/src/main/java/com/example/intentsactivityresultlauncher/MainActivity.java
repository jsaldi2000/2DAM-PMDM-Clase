package com.example.intentsactivityresultlauncher;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1. Declarar el ActivityResultLauncher, que se usará para lanzar una actividad y obtener el resultado
    private ActivityResultLauncher<Intent> activityResultLauncher;

    // 2. Método que se invoca cuando se desea lanzar la segunda actividad (Activity2)
    public void launchActivity2(View view) {
        // Crea una nueva Intent para lanzar Activity2
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        // Añade un mensaje extra para pasar a la siguiente actividad
        intent.putExtra("message", "Hola desde MainActivity");
        // Lanza Activity2 y espera el resultado a través del ActivityResultLauncher
        activityResultLauncher.launch(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3. Configura el lanzador para recibir el resultado de la actividad
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), // Especifica que se desea recibir un resultado de la actividad
                result -> { // Este es el manejador de resultados

                    // Verifica si el resultado de la actividad fue OK
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData(); // Obtiene los datos que la actividad ha devuelto
                        if (data != null) {
                            // Obtiene un mensaje extra que la otra actividad pasó como respuesta
                            String responseMessage = data.getStringExtra("responderMensaje");
                            // Muestra un mensaje con el resultado usando un Toast
                            Toast.makeText(this, "Respuesta: " + responseMessage, Toast.LENGTH_SHORT).show();
                        }
                    } else if (result.getResultCode() == RESULT_CANCELED) {
                        // Si la actividad fue cancelada, muestra un mensaje de cancelación
                        Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }



}
