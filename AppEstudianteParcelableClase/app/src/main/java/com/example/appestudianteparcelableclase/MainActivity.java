package com.example.appestudianteparcelableclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appestudianteparcelableclase.model.Estudiante;

public class MainActivity extends AppCompatActivity {

    // Declaración de campos
    private EditText etNombre, etEdad, etCurso, etNotaFinal;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignar los componentes a la vista
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etCurso = findViewById(R.id.etCurso);
        etNotaFinal = findViewById(R.id.etNotaFinal);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Asignar acción a través de un listener
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // obtener los datos de los campos de entrada
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                String curso = etCurso.getText().toString();
                double notaFinal = Double.parseDouble (etNotaFinal.getText().toString());

                // Crear el objeto Estudiante
                Estudiante estudiante = new Estudiante(nombre, edad, curso, notaFinal);

                // Enviar el objeto estudiante a DetalleActivity
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("Estudiante", estudiante);
                startActivity(intent);

            }
        });

    }
}