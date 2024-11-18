package com.example.intentsimplicitosweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para realizar la acción a través de un intent implícito
    public void openUrl(View view) {
        Button btnOpenUrl = findViewById(R.id.btnOpenUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE); // Solo aplicaciones que pueden navegar por internet, si hay una por defecto será esta
        intent.setData(Uri.parse("https://universidadeuropea.com/"));
        startActivity(intent);
    }

    // Método asociado al onClick para abrir el marcador con un número
    public void openDialer(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+34600100600")); // Número preconfigurado
        startActivity(intent);
    }

    // Método asociado al onClick para abrir la app de mensajería
    public void sendSms(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:+34600100600")); // Número preconfigurado
        intent.putExtra("sms_body", "Hola Juan, ¿cómo estás?");
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // MIME específico para correos electrónicos
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"}); // Dirección de correo
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reclamación cliente"); // Asunto del correo
        intent.putExtra(Intent.EXTRA_TEXT, "Estimado departamento de atención al cliente, deseo presentar una queja formal para..."); // Cuerpo del correo

        // Puede fallar porque no reconozca el cliente gmail, usamos esto
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Elige un cliente de correo"));
        } else {
            Toast.makeText(this, "No se encontró un cliente de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }

    public void playVideo(View view) {

    // VideoView configurado en el layout
    VideoView vvVideo = findViewById(R.id.vvVideo);

    // Ruta al video en res/raw
    String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
    Uri uri = Uri.parse(uriPath);

    // Configurar y reproducir el video
        vvVideo.setVideoURI(uri);
        vvVideo.start();
    }


}
