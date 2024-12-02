package com.example.rotacionpantallarecuperaractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Escribir "tag:CicloDeVida llamado" en el filtro de logcat para ver los tags creados en cada evento
public class MainActivity extends AppCompatActivity {

    // Creamos TAG para ver logcat
    private static final String TAG = "CicloDeVida"; // Etiqueta para los eventos

    private EditText etNumero1, etNumero2;
    private TextView tvResultado;
    private int resultado = 0; // Variable dinámica que se restaurará manualmente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registro de onCreate
        Log.d(TAG, "onCreate llamado");
        Toast.makeText(this, "onCreate llamado", Toast.LENGTH_SHORT).show();

        // Referencias a los componentes
        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        tvResultado = findViewById(R.id.tvResultado);

        // Restaurar el estado si savedInstanceState no es null
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getInt("resultado", 0); // Restaurar el resultado
            tvResultado.setText("Resultado: " + resultado); // Actualizar el TextView
        }
    }

    // Método asociado al botón definido en el XML
    public void multiplicarNumeros(View view) {

        // Registro de multiplicarNumeros
        Log.d(TAG, "multiplicarNumeros llamado");
        Toast.makeText(this, "multiplicarNumeros llamado", Toast.LENGTH_SHORT).show();


        try {
            int numero1 = Integer.parseInt(etNumero1.getText().toString());
            int numero2 = Integer.parseInt(etNumero2.getText().toString());
            resultado = numero1 * numero2; // Calcular la multiplicación
            tvResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, introduce números válidos", Toast.LENGTH_SHORT).show();
        }


    }

    // Guardar el estado de la variable resultado
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Registro de onSaveInstanceState
        Log.d(TAG, "onSaveInstanceState llamado");
        Toast.makeText(this, "onSaveInstanceState llamado", Toast.LENGTH_SHORT).show();

        // Guardar el resultado en el bundle outState
        outState.putInt("resultado", resultado);
    }

    // Restaurar el estado de la variable resultado
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Registro de onSaveInstanceState
        Log.d(TAG, "onRestoreInstanceState llamado");
        Toast.makeText(this, "onRestoreInstanceState llamado", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            // Recuperar el resultado guardado en el bundle outState
            resultado = savedInstanceState.getInt("resultado", 0);
        }

        // Actualizar el TextView con el resultado restaurado
        tvResultado.setText("Resultado: " + resultado);
    }
}

