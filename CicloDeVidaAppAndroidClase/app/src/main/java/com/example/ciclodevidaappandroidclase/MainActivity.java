package com.example.ciclodevidaappandroidclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

// Debéis escribir "tag:CicloDeVida llamado" en el filtro de logcat para ver los tags que hemos creado
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloDeVida"; // Etiqueta para los logs
    private TextView tvComentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia a la vista
        tvComentarios = findViewById(R.id.tvComentarios);

        // Registro mensaje en el onCreate
        Log.d(TAG, "onCreate llamado");
        Toast.makeText(this, "onCreate llamado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart(){
        super.onStart();

        // Registro mensaje el onStart
        Log.d(TAG, "onStart llamado");
        Toast.makeText(this, "onStart llamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Registro de onResume
        Log.d(TAG, "onResume llamado");
        Toast.makeText(this, "onResume llamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Registro de onPause
        Log.d(TAG, "onPause llamado");
        Toast.makeText(this, "onPause llamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Registro de onStop
        Log.d(TAG, "onStop llamado");
        Toast.makeText(this, "onStop llamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        // Registro de onRestart
        Log.d(TAG, "onRestart llamado");
        Toast.makeText(this, "onRestart llamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Registro de onDestroy
        Log.d(TAG, "onDestroy llamado");
        Toast.makeText(this, "onDestroy llamado", Toast.LENGTH_SHORT).show();
    }


}