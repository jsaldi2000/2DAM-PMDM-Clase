package com.example.intentsimplicitosweb2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.view.View;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para abrir búsqueda en navegador
    public void abrirBusqueda(View view){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "Intents para mi proyecto"); // Palabra clave a buscar
        startActivity(intent);
    }

    // Método para seleccionar un contacto
    public void seleccionarContacto(View view){
        // REQUEST_CONTACT_PICK es una constante definida para identificar la actividad al volver
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


    // Método para abrir ubicacion en G. Maps
    public void abrirUbicacion(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=UEM Alcobendas")); // Localizacion de la UEM en Alcobendas
        startActivity(intent);
    }

    // Método para configurar alarma
    public void configurarAlarma(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 8); // Hora de la alarma
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30); // Minutos de la alarma
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Ir a clase"); // Mensaje de la alarma
        startActivity(intent);
    }
}