package com.example.enbuscadelintentperdido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }

    // Método para crear el intent y ver la web oculta.
    public void verWeb(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addCategory(Intent.CATEGORY_BROWSABLE); // Solo aplicaciones que pueden navegar por internet, si hay una por defecto será esta
        i.setData(Uri.parse("https://developer.android.com/guide/components/intents-filters?hl=es-419"));
        startActivity(i);
    }

    // Método para manejar el botón Salir (con FLAG para destruir toda la pila de actividades y volver a una Actividad concreta.)
    public void salir(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}