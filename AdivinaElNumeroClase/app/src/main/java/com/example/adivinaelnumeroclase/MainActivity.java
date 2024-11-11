package com.example.adivinaelnumeroclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adivinaelnumeroclase.data.Datos;

public class MainActivity extends AppCompatActivity {

    // Declaración variables necesarias (numSecreto y contIntentos)
    private int numSecreto;
    private int contIntentos;

    // Declaración componentes
    TextView tvIntentos;
    TextView tvPista;
    EditText etNumero;
    Button btnComprobar;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización variables necesarias (numSecreto y contIntentos)
        numSecreto = Datos.generarNumSecreto();
        contIntentos = Datos.NUM_INTENTOS;

        // Asignar todos los componentes de la interfaz para usar en el controlador
        tvIntentos = findViewById(R.id.tvIntentos);
        tvPista = findViewById(R.id.tvPista);
        etNumero = findViewById(R.id.etNumero);
        btnComprobar = findViewById(R.id.btnComprobar);
        cl = findViewById(R.id.clFondo);

        // CONFIGURACIÓN DE TEXTOS para los componentes
        // Pasamos al tvIntentos el valor del string en strings.xml, tv_intentos y sustituimos el valor variable (%1$d) por contIntentos
        Resources res = getResources();
        tvIntentos.setText(String.format(res.getString(R.string.tv_intentos), contIntentos));

        // Pasamos al tvPista el valor del string en strings.xml, tv_pista_ini y sustituimos los valores variables (%1$d, %2$d, %3$d) por MIN, MAX y NUM_INTENTOS
        tvPista.setText(String.format(res.getString(R.string.tv_pista_ini),Datos.MIN, Datos.MAX, Datos.NUM_INTENTOS));

        // Pasamos al etNumero el valor del string en strings.xml, hint_numero y sustituimos los valores variables (%1$d, %2$d) por MIN, MAX
        etNumero.setHint(String.format(res.getString(R.string.hint_numero),Datos.MIN, Datos.MAX));

        etNumero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    etNumero.setText(""); // Borra el contenido del EditText
                }
                return false; // Permite que otros eventos, como abrir el teclado, también se activen
            }
        });
    }

    public void comprobarNumero(View v) {
        String sNum = etNumero.getText().toString();
        if (sNum.isEmpty()) {
            Toast.makeText(this, R.string.num_oblig,
                    Toast.LENGTH_LONG).show();
        } else {
            int numeroIntro = Integer.parseInt(sNum);

            // comparar el número introducido vs el num secreto
            boolean acierto = false;
            if (numeroIntro == numSecreto) {
                // acierto
                acierto = true;
                fin(String.format(getString(R.string.acertar),
                        numSecreto), R.color.colorOK);

            } else if (numeroIntro > numSecreto) {
                // indicar que el número es más pequeño
                tvPista.setText(getString(R.string.numero_menor));

            } else {
                // indicar que el número es más grande
                tvPista.setText(getString(R.string.numero_mayor));
            }

            // Disminuir los intentos y mostrarlos en el Text View
            contIntentos--;
            tvIntentos.setText(String.format(getString(R.string.tv_intentos),
                    contIntentos));

            // Finalizar el juego si los intentos se han terminado
            if (contIntentos == 0 && !acierto) {
                fin(String.format(getString(R.string.error),
                        numSecreto), ContextCompat.getColor(this,R.color.colorKO));
            }
        }
    }

    // Con este método mostramos al usuario que ha acertado y cambiamos el color del layout
    private void fin(String textoPista, int color) {

        // Argumento que recibe el método para mostrar en el tvPista
        tvPista.setText(textoPista);

        // Argumento que recibe el método para cambiar el color del layout
        cl.setBackgroundColor(color);

        // Cambiar también texto del botón y desactivar el botón de prueba
        btnComprobar.setText(getString(R.string.btn_fin));
        btnComprobar.setEnabled(false);
    }

}