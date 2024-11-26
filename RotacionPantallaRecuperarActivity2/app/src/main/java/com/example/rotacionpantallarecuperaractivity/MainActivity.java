package com.example.rotacionpantallarecuperaractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


// Escribir "tag:CicloDeVida llamado" en el filtro de logcat para ver los tags creados en cada evento
public class MainActivity extends AppCompatActivity {

    // Creamos el TAG para ver los eventos en logcat
    private static final String TAG = "CicloDeVida"; // Etiqueta para los eventos del logcat

    private EditText etNumero1, etNumero2;
    private TextView tvResultado;
    private int resultado = 0; // Variable que se restaurará manualmente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registro de onCreate
        Log.d(TAG, "onCreate llamado");

        // Referenciamos los componentes
        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        tvResultado = findViewById(R.id.tvResultado);

//        // Restaurar el estado si savedInstanceState no es null
//        if (savedInstanceState != null){
//            resultado = savedInstanceState.getInt("resultado", 0);
//            tvResultado.setText("Resultado: " + resultado); // Actualizar TextView después de rotar la pantalla
//        }

    }

    public void multiplicarNumeros(View view){

        // Registro de multiplicarNumeros
        Log.d(TAG, "multiplicarNumeros llamado");

        int numero1 = Integer.parseInt(etNumero1.getText().toString());
        int numero2 = Integer.parseInt(etNumero2.getText().toString());
        resultado = numero1 * numero2;
        tvResultado.setText("Resultado: " + resultado);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Registro de onSaveInstanceState
        Log.d(TAG, "onSaveInstanceState llamado");

        // Guardar el resultado en el bundle outState
        outState.putInt("resultado", resultado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        // Registro de onSaveInstanceState
        Log.d(TAG, "onRestoreInstanceState llamado");

        if (savedInstanceState != null){
            resultado = savedInstanceState.getInt("resultado", 0);
        }

        // Actualizar TextView con el restultado restaurado
        tvResultado.setText("Resultado : " + resultado);
    }

}