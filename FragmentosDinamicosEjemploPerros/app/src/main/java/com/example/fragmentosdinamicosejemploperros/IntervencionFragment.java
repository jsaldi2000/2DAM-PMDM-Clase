package com.example.fragmentosdinamicosejemploperros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IntervencionFragment extends Fragment {

    // Método estático para crear una nueva instancia de IntervencionFragment.
    // argumento intervencion es un objeto Intervencion que contiene la información para crear cada fragmento
    public static IntervencionFragment newInstance(Intervencion intervencion) {

        // Método fábrica que se utiliza para crear una nueva instancia del fragmento IntervencionFragment
        IntervencionFragment fabricaFragmento = new IntervencionFragment();

        // Crea un Bundle e incluye los datos de la intervención, que serán transferidos al fragmento.
        Bundle datosIntervencion = new Bundle();
        datosIntervencion.putString("fecha", intervencion.getFecha());
        datosIntervencion.putString("motivo", intervencion.getMotivo());
        datosIntervencion.putString("observaciones", intervencion.getObservaciones());

        // Asigna los datos de la intervención obtenidos antes al Bundle, y lo devuelve para ser usado.
        fabricaFragmento.setArguments(datosIntervencion);
        return fabricaFragmento;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflar la Vista
        // false Indica que la vista no se debe agregar automáticamente al contenedor. Esto lo hace Android posteriormente.
        View view = inflater.inflate(R.layout.fragment_intervencion, container, false);

        // Recupera los datos pasados al fragmento a través del Bundle.
        String fecha = getArguments().getString("fecha");
        String motivo = getArguments().getString("motivo");
        String observaciones = getArguments().getString("observaciones");

        // Obtiene las referencias de los componentes de la interfaz
        TextView tvFecha = view.findViewById(R.id.tvFecha);
        TextView tvMotivo = view.findViewById(R.id.tvMotivo);
        TextView tvObservaciones = view.findViewById(R.id.tvObservaciones);

        // Mostrar valores en cada fragmento creado
        tvFecha.setText("Fecha: " + fecha);
        tvMotivo.setText("Motivo: " + motivo);
        tvObservaciones.setText("Observaciones: " + observaciones);

        return view;
    }
}
