package com.example.fragmentosestaticosclase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContadorFragment extends Fragment {

    private EditText etTexto;
    private TextView tvLetras;
    private Button btnCalcular;

    public ContadorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contador, container, false);

        // Inicializamos los componentes
        etTexto = view.findViewById(R.id.etTexto);
        tvLetras = view.findViewById(R.id.tvLetras);
        btnCalcular = view.findViewById(R.id.btnCalcular);

        // Crear onClickListener para realizar el cálculo en el TextView
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

        return view;

    }

    private void calcular() {
        String texto = etTexto.getText().toString();
        int numeroLetras = texto.length();
        tvLetras.setText("Número de caracteres: " + numeroLetras);
    }

    // Guardamos variable en el bundle outState para recuperar en rotación de pantalla
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onViewStateRestored(outState);

        // Guardar el texto del TextView en el bundle
        outState.putString("textoGuardado", tvLetras.getText().toString());
    }


    // Recuperamos el bundle con onViewStateRestored
    @Override
    public void onViewStateRestored(Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);

        if (saveInstanceState != null){

            // Recuperamos el valor del bundle
            tvLetras.setText(saveInstanceState.getString("textoGuardado", ""));
        }
    }
}