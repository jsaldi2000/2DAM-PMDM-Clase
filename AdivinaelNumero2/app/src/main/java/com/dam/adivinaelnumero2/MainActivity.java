package com.dam.adivinaelnumero2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.adivinaelnumero2.data.Datos;

public class MainActivity extends AppCompatActivity {

    static final String CLAVE_NUM_SEC = "NUM_SECRETO";
    static final String CLAVE_CONT_INT = "CONT_INTENTOS";
    static final String CLAVE_NICK = "NICK";
    static final String CLAVE_PISTA = "PISTA";
    static final String CLAVE_COLOR = "COLOR";

    private int numSecreto;
    private int contIntentos;
    private String nick;
    private String pista;
    private int idColor;

    TextView tvIntentos;
    TextView tvPista;
    EditText etNumero;
    Button btnComprobar;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvIntentos = findViewById(R.id.tvIntentos);
        tvPista = findViewById(R.id.tvPista);
        etNumero = findViewById(R.id.etNumero);
        btnComprobar = findViewById(R.id.btnComprobar);
        rl = findViewById(R.id.rlFondo);

        if (savedInstanceState == null) {
            nick = getIntent().getStringExtra(InicioActivity.CLAVE_NICK);
            contIntentos = getIntent()
                    .getIntExtra(InicioActivity.CLAVE_INTENTOS, Datos.NUM_INTENTOS);
            numSecreto = Datos.generarNumSecreto();

            pista = String.format(getResources().getString(R.string.tv_pista_ini),
                    Datos.MIN, Datos.MAX, contIntentos, nick);

            idColor = R.color.colorFondo;

            etNumero.setHint(String.format(getString(R.string.hint_numero),
                    Datos.MIN, Datos.MAX));
        } else {
            nick = savedInstanceState.getString(CLAVE_NICK);
            contIntentos = savedInstanceState.getInt(CLAVE_CONT_INT);
            numSecreto = savedInstanceState.getInt(CLAVE_NUM_SEC);

            pista = savedInstanceState.getString(CLAVE_PISTA);
            idColor = savedInstanceState.getInt(CLAVE_COLOR);

        }

        tvIntentos.setText(
                String.format(getResources().getString(R.string.tv_intentos),
                        contIntentos));

        tvPista.setText(pista);
        rl.setBackgroundResource(idColor);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLAVE_NUM_SEC, numSecreto);
        outState.putInt(CLAVE_CONT_INT, contIntentos);
        outState.putString(CLAVE_NICK, nick);
        outState.putString(CLAVE_PISTA, pista);
        outState.putInt(CLAVE_COLOR, idColor);
    }

    public void comprobarNumero(View v) {
        String sNum = etNumero.getText().toString();
        if (sNum.isEmpty()) {
            Toast.makeText(this, R.string.num_oblig,
                    Toast.LENGTH_LONG).show();
        } else {
            contIntentos--;
            compararNumero(sNum);
        }
    }

    private void compararNumero(String sNum) {
        int numeroIntro = Integer.parseInt(sNum);

        // comparar
        boolean acierto = false;
        if (numeroIntro == numSecreto) {
            // acierto
            acierto = true;
            fin(String.format(getString(R.string.acertar),
                    numSecreto, nick), R.color.colorOK);

        } else if (numeroIntro > numSecreto) {
            // indicar que el número es más pequeño
            pista = String.format(getString(R.string.numero_menor), nick);

        } else {
            // indicar que el número es más grande
            pista = String.format(getString(R.string.numero_mayor), nick);
        }

        tvPista.setText(pista);
        tvIntentos.setText(String.format(getString(R.string.tv_intentos),
                contIntentos));

        if (contIntentos == 0 && !acierto) {
            fin(String.format(getString(R.string.error),
                    numSecreto, nick), R.color.colorKO);
        }
    }

    private void fin(String textoPista, int color) {
        tvPista.setText(textoPista);
        rl.setBackgroundResource(color);
        btnComprobar.setText(getString(R.string.btn_fin));
        btnComprobar.setEnabled(false);
        idColor = color;
    }
}