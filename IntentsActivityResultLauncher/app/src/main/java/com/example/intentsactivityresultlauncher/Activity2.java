package com.example.intentsactivityresultlauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recupera el mensaje enviado desde MainActivity a través de la Intent
        TextView textView = findViewById(R.id.tvMensajeRecibido);
        String message = getIntent().getStringExtra("message"); // Recupera el mensaje enviado con la clave "message"
        textView.setText("Mensaje recibido: " + message); // Muestra el mensaje recibido en el TextView

        // Configura el botón que enviará un resultado de vuelta a MainActivity
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(v -> {
            // Crea un nuevo Intent para enviar el resultado de vuelta
            Intent resultIntent = new Intent();
            // Añade un mensaje como respuesta que se enviará a MainActivity
            resultIntent.putExtra("responderMensaje", "Hola desde Activity2");
            // Establece el código de resultado como RESULT_OK y envía el Intent de resultado
            setResult(RESULT_OK, resultIntent);
            // Finaliza Activity2 y vuelve a MainActivity
            finish();
        });
    }
}
