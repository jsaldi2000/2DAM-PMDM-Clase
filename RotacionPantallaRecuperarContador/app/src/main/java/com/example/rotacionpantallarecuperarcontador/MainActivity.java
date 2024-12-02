package com.example.rotacionpantallarecuperarcontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloDeVida"; // Etiqueta para los Logs
    private TextView tvContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Traza logcat
        Log.d(TAG, "onCreate llamado");

        // Inicializar componentes
        tvContador = findViewById(R.id.tvContador);
        Button btnIncrementar = findViewById(R.id.btnIncrementar);
        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        // Asociar métodos a los botones
        btnIncrementar.setOnClickListener(v -> incrementarContador());
        btnReiniciar.setOnClickListener(v -> reiniciarContador());
    }


    // Trazas logcat
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart llamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume llamado");
    }


    // Incrementar el contador
    private void incrementarContador() {
        contador++;
        tvContador.setText(String.valueOf(contador));
    }

    // Reiniciar el contador
    private void reiniciarContador() {
        contador = 0;
        tvContador.setText(String.valueOf(contador));
    }

    // Guardar el estado del contador
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Traza logcat
        Log.d(TAG, "onSaveInstanceState llamado");

        outState.putInt("contador", contador);

    }

    // Restaurar el estado del contador
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Traza logcat
        Log.d(TAG, "onRestoreInstanceState llamado");

        contador = savedInstanceState.getInt("contador", 0); // 0 es el valor predeterminado
        tvContador.setText(String.valueOf(contador));
    }

    // Trazas logcat
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy llamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart llamado");
    }

}
