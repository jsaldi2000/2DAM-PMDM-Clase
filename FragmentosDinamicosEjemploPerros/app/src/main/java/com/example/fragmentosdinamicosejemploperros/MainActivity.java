package com.example.fragmentosdinamicosejemploperros;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNombrePerro;
    private Button btnSeleccionar;

    // ActivityResultLauncher para manejar el resultado de la actividad de selección
    private ActivityResultLauncher<Intent> seleccionPerroLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar los componentes de la vista
        etNombrePerro = findViewById(R.id.etNombrePerro);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);

        // Configurar el ActivityResultLauncher
        seleccionPerroLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                result -> {

                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                        // Si el resultado es OK, obtener el nombre del perro seleccionado en la activity SeleccionPerroActivity
                        String nombrePerro = result.getData().getStringExtra("nombrePerro");

                        // Recibimos el nombre del perro seleccionado del intent
                        if (nombrePerro != null) {
                            // Asignamos el nombre del perro al EditText y cambiamos el botón a "Limpiar Datos"
                            etNombrePerro.setText(nombrePerro);
                            btnSeleccionar.setText("Limpiar Datos");

                            // Cargamos fragmentos dinámicos con las intervenciones del perro seleccionado
                            cargarIntervenciones(nombrePerro);
                        }
                    }
                }
        );

        // Configuramnos el botón para lanzar la actividad o cambiamos el botón a "limpiar datos" si es que hay un perro seleccionado
        btnSeleccionar.setOnClickListener(view -> {
                    if (btnSeleccionar.getText().toString().equals("Seleccionar Perro")) {

                        // Lanzar la actividad para seleccionar un perro
                        Intent intent = new Intent(MainActivity.this, SeleccionPerroActivity.class);
                        seleccionPerroLauncher.launch(intent);

                        // Limpiamos los datos y reiniciamos la vista para poder seleccionar un perro nuevo
                    } else {
                        limpiarDatos();
                    }
                }

        );
    }

    // Método para cargar los fragmentos dinámicos
    private void cargarIntervenciones(String nombrePerro) {

        // Crear una instancia de PerrosDatos que contiene todos los datos
        PerrosDatos datosPerros = new PerrosDatos();

        // Buscar el perro seleccionado en los datos de la instnacia
        Perro perro = datosPerros.getPerroPorNombre(nombrePerro);

        // Obtener el FragmentManager y comenzar la transacción
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Crear un fragmento dinámico para cada una de las intervenciones del perro
        for (Intervencion intervencion : perro.getIntervenciones()) {

            // CLASE IntervencionFragment
            // Crear el fragmento a través de una instancia de IntervencionFragment (que recibe cada intervención del perro seleccionado).
            IntervencionFragment fragment = IntervencionFragment.newInstance(intervencion);

            // Agregar cada fragmento dinámico al contenedor
            ft.add(R.id.contenedorFragmentos, fragment);

        }

        // Confirmar la transacción, hasta que no se llame a commit los cambios en la transacción no se reflejan en la interfaz de usuario.
        ft.commit();
    }


    // Método para limpiar los datos del EditText, cambiar el texto del botón a "Seleccionar Perro" y eliminar los fragmentos cargados anteriormente
    private void limpiarDatos() {

        // Limpiar los datos de los componentes de la vista
        etNombrePerro.setText("");
        btnSeleccionar.setText("Seleccionar Perro");

        // Obtener el FragmentManager (necesario para manejar fragmetnos) y FragmentTransaction (se utiliza para agrupar y realizar múltiples cambios relacionados con fragmentos)
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Obtener la lista de fragmentos actualmente gestionados por el FragmentManager
        List<Fragment> fragmentosActivos = fm.getFragments();

        // Recorrer y procesar los fragmentos para eliminarlos
        for (Fragment fragment : fragmentosActivos) {
            if (fragment instanceof IntervencionFragment) {
                // Agregar la eliminación de cada fragmento a la transacción actual
                ft.remove(fragment);
            }
        }

        // Confirmar la transacción para reflejar los cambios en la interfaz de usuario
        ft.commit();
    }
}
