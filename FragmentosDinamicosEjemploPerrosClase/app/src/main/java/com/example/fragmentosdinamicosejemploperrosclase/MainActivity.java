package com.example.fragmentosdinamicosejemploperrosclase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNombrePerro;
    private Button btnSeleccionar;

    // ActivityResultLauncher para manejar el resultado de la actividad de selección de perro
    private ActivityResultLauncher<Intent> seleccionPerroLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombrePerro = findViewById(R.id.etNombrePerro);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);

        // Configurar el ActivityResultLauncher
        seleccionPerroLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                result -> {

                    if (result.getResultCode() == RESULT_OK && result.getData() != null){

                        // Si el resultado es OK, obtengo el nombre del perro seleccionado
                        String nombrePerro = result.getData().getStringExtra("nombrePerro");

                        if (nombrePerro != null) {
                            etNombrePerro.setText(nombrePerro);
                            btnSeleccionar.setText("Limpiar Datos");

                            // Cargaremos las intervenciones del perro seleccionado
                            cargarIntervenciones(nombrePerro);
                        }
                    }

                }
        );

        // Configuramos el botón Seleccionar Perro para lanzar la actividad
        btnSeleccionar.setOnClickListener(view -> {
            if (btnSeleccionar.getText().toString().equals("Seleccionar Perro")){

                // lanzo la actividad para seleccionar un perro
                Intent intent = new Intent(MainActivity.this, SeleccionPerroActivity.class);
                seleccionPerroLauncher.launch(intent);
            } else {
                limpiarDatos();
            }
        });
    }

    // Método para cargar los fragmentos dinámicos
    private void cargarIntervenciones(String nombrePerro) {

        // Crear una instancia de PerrosDatos que contiene todos los datos
        PerrosDatos datosPerros = new PerrosDatos();

        // Buscar el perro seleccionado en los datos de la instancia
        Perro perro = datosPerros.getPerroPorNombre(nombrePerro);

        // Obtener un FragmentManager y comenzar la transacción
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Crear una fragmento dinámico para cada una de las intervenciones del perro
        for (Intervencion intervencion : perro.getIntervenciones()){

            // Clase IntervencionFragment
            IntervencionFragment fragment = IntervencionFragment.newInstance(intervencion);

            // Agregar cada fragmento dinámico al contenedor
            ft.add(R.id.contenedorFragmentos, fragment);
        }
        ft.commit();

    }

    private void limpiarDatos(){

        etNombrePerro.setText("");
        btnSeleccionar.setText("Seleccionar Perro");

        // Obtener un FragmentManager y comenzar la transacción
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //Obtener la lista de fragmentos actualmente gestionados por el FragmentManager
        List<Fragment> fragmentosActivos = fm.getFragments();

        // recorro la lista y elimo los fragmentos activos
        for (Fragment fragment : fragmentosActivos){
            if (fragment instanceof IntervencionFragment){
                ft.remove(fragment);
            }
        }

        ft.commit();

    }
}