package com.example.intentsimplicitoswebclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para realizar la apertura de la página web
    public void openUrl(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://universidadeuropea.com/"));
        startActivity(intent);
    }

    // Método para abrir el marcador de llamadas
    public void openDialer(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+34600100600"));
        startActivity(intent);
    }

    // Método para enviar un SMS
    public void sendSms(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:+34600100600"));
        intent.putExtra("sms_body", "Hola Juan, ¿cómo estás?");
        startActivity(intent);
    }

    // Método para enviar un correo prediseñado
    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // MIME o tipo de datos específicos para correos electrónicos
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"micorreo@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reclamación del cliente");
        intent.putExtra(Intent.EXTRA_TEXT, "Estimado departamento de atención al cliente, deseo presentar una queja formal para bla bla bla bla bla bla bla ....");

        // puede fallar porque no reconozca el cliente gmail, usamos
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Elige un cliente de correo"));

        } else {
            Toast.makeText(this, "No se encontró ninguna app de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }


    // Método para reproducir el video en el Video View
    public void playVideo(View view){

        // Asignar el video view
        VideoView vvVideo = findViewById(R.id.vvVideo);

        // Ruta al video en res/raw
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(uriPath);

        // configuro y reproduzco
        vvVideo.setVideoURI(uri);
        vvVideo.start();
    }

}