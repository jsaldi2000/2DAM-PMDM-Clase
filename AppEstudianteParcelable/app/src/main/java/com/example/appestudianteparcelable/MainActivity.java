package com.example.appestudianteparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appestudianteparcelable.model.Estudiante;

public class MainActivity extends AppCompatActivity {

    // Declaración de campos
    private EditText etNombre, etEdad, etCurso, etNotaFinal;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los campos y componentes
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etCurso = findViewById(R.id.etCurso);
        etNotaFinal = findViewById(R.id.etNotaFinal);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Asignar acción a través de Listener
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener los datos de los campos de entrada
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                String curso = etCurso.getText().toString();
                double notaFinal = Double.parseDouble(etNotaFinal.getText().toString());

                // Crear el objeto Estudiante
                Estudiante estudiante = new Estudiante(nombre, edad, curso, notaFinal);

                // Enviar el objeto Estudiante a Activity2
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("estudiante", estudiante);
                startActivity(intent);

            }
        });

    }



}