package com.example.hechoscuriosos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los elementos de la vista con el código Java
        TextView tvSabiasQue = findViewById(R.id.tvSabiasQue);
        TextView tvHechoCurioso = findViewById(R.id.tvHechoCurioso);
        Button btnVerOtroHecho = findViewById(R.id.btnVerOtroHecho);

        // Configurar el listener del botón
        btnVerOtroHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar el texto del TextView con otro hecho curioso
                tvHechoCurioso.setText("Los delfines duermen con un ojo abierto.");
            }
        });
    }
}
