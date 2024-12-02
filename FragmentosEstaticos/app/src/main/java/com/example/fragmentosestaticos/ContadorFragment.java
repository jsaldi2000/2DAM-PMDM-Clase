package com.example.fragmentosestaticos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ContadorFragment extends Fragment {

    private static final String TAG = "CicloDeVida"; // Etiqueta para los Logs
    private EditText etTexto;
    private Button btnCalcular;
    private TextView tvLetras;

    public ContadorFragment() {
        // Constructor vacío requerido
    }

    // Se llama cuando el fragmento se asocia a la actividad
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach Fragmento");
    }

    // Se llama para inicializar el fragmento
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate Fragmento");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Traza logcat
        Log.d(TAG, "onCreateView Fragmento");

        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_contador, container, false);

        // Referenciar los componentes
        etTexto = view.findViewById(R.id.etTexto);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        tvLetras = view.findViewById(R.id.tvLetras);

        // Configurar la acción del botón
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = etTexto.getText().toString();
                int numeroLetras = texto.length();
                tvLetras.setText("Número de caracteres: " + numeroLetras);
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

        // onSaveInstanceState guardado de número de caracteres
        Log.d(TAG, "onSaveInstanceState Fragmento");

        // Guardar el texto del TextView en el bundle
        outState.putString("textoGuardado", tvLetras.getText().toString());
    }


    // Recuperamos el bundle con onViewStateRestored
    @Override
    public void onViewStateRestored(Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);

        // onViewStateRestored recuperación de número de caracteres
        Log.d(TAG, "onViewStateRestored Fragmento");

        if (saveInstanceState != null){

            // Recuperamos el valor del bundle
            tvLetras.setText(saveInstanceState.getString("textoGuardado", ""));
        }
    }

    // Se llama cuando la actividad asociada al fragmento ha completado su `onCreate`
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated Fragmento");
    }

    // Se llama cuando el fragmento está a punto de ser visible
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart Fragmento");
    }

    // Se llama cuando el fragmento está completamente interactivo
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume Fragmento");
    }

    // Se llama cuando el fragmento pierde el enfoque
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause Fragmento");
    }

    // Se llama cuando el fragmento ya no es visible
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop Fragmento");
    }

    // Se llama para limpiar recursos asociados a la vista
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView Fragmento");
    }

    // Se llama para liberar todos los recursos del fragmento
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy Fragmento");
    }

    // Se llama cuando el fragmento se disocia de la actividad
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach Fragmento");
    }

}
