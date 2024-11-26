package com.example.enbuscadelintentperdidoclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
    }

    // Método llamado cuando presiona "Con Llave" y vuelve al Activity4 (que es quien ha lanzado el launcher)
    public void conLlave(View view){
        setResult(RESULT_OK); // Se ha ontenido la llave y se manda el reusltado al ActivityForResult de la Activity4
        finish();
    }

    // Método cuando presiona "Sin Llave"
    public void sinLlave(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}