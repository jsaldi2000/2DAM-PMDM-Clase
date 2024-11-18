package com.dam.ebdip;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {

    Button btnConLlave;
    Button btnSinLlave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        // Inicializar botones
        btnConLlave = findViewById(R.id.btnConLlave);
        btnSinLlave = findViewById(R.id.btnSinLlave);
    }

    // Método llamado cuando se presiona el botón "Con Llave"
    public void conLlave(View view) {
        setResult(RESULT_OK); // Se ha obtenido la llave y se manda el resultado al ActivityForResult
        finish(); // Finaliza la actividad y vuelve al Activity4
    }

    // Método llamado cuando se presiona el botón "Sin Llave"
    public void sinLlave(View view) {
        setResult(RESULT_CANCELED); // No se ha obtenido la llave y se manda el resultado al ActivityForResult
        finish(); // Finaliza la actividad y vuelve al Activity4
    }
}