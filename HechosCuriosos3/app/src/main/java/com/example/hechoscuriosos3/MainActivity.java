package com.example.hechoscuriosos3;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Declaramos las variables para las vistas
    private TextView tvHechoCurioso;
    private Button btnVerHecho;

    // Crear objeto listaHechos
    ListaHechos listaHechos = new ListaHechos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar las vistas con el código Java
        tvHechoCurioso = findViewById(R.id.tvHechoCurioso);
        btnVerHecho = findViewById(R.id.btnVerOtroHecho);


/*        // Añadir el OnClickListener al botón
        btnVerHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvHechoCurioso.setText(listaHechos.getHechoAleatorio());
            }
        });*/


    }

    // Creamos método independiente para asignar al botón Ver Otro Hecho
    public void mostrarHechoCurioso(View view) {

        // Usar método de ListaHechos para asignar hecho aleatorio al Text View
        tvHechoCurioso.setText(listaHechos.getHechoAleatorio());

        // Crear objeto ColoresFondo para poder asignarlos
        ColoresFondo coloresFondo = new ColoresFondo();
        RelativeLayout layoutPrincipal = findViewById(R.id.layoutPrincipal);
        layoutPrincipal.setBackgroundColor(coloresFondo.getColorAleatorio());

    }


}

