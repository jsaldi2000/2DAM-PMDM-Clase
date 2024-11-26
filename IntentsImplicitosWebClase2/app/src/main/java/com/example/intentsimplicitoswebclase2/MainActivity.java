package com.example.intentsimplicitoswebclase2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para abrir búsqueda en el navegador
    public void abrirBusqueda(View view){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "Intents para mi proyecto");
        startActivity(intent);
    }

    // Método para seleccionar un contacto
    public void seleccionarContacto(View view){

        // Este método necesita una variable REQUES_CONTACT_PICK, para identificar la actividad al volver
        final int REQUEST_CONTACT_PICK = 1;

        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, REQUEST_CONTACT_PICK);
    }

    // Método para mostrar detalles de un contacto
    public void mostrarContacto(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/1")); // ID del contacto
        startActivity(intent);
    }

    // Método para abrir ubicación en Google Maps
    public void abrirUbicacion(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?=UEM Alcobendas")); // Localización de la UEM en Alcobendas
        startActivity(intent);
    }
}