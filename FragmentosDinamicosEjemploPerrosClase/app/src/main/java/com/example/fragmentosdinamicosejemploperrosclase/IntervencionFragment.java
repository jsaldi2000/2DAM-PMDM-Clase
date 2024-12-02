package com.example.fragmentosdinamicosejemploperrosclase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IntervencionFragment extends Fragment {

    // Método estático para crear una nueva instancia de IntervencionFragment
    // tiene un argumento, que es cada una de las intervenciones de los perros

    public static IntervencionFragment newInstance(Intervencion intervencion){

        // Metodo fábrica que se utiliza para crear una nueva instancia del fragmento IntervencionFragment
        IntervencionFragment fabricaFragmento = new IntervencionFragment();

        // Crear un bundle e incluir los datos de la intervención, que serán transferidos al fragmento
        Bundle datosIntervencion = new Bundle();
        datosIntervencion.putString("fecha", intervencion.getFecha());
        datosIntervencion.putString("motivo", intervencion.getMotivo());
        datosIntervencion.putString("observaciones", intervencion.getObservaciones());

        // Asigno los datos de la intervencion obtenidos antes al Bundle, para devolverlo y que pueda ser usado
        fabricaFragmento.setArguments(datosIntervencion);

        return fabricaFragmento;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflar la vista
        View view = inflater.inflate(R.layout.fragment_intervencion, container, false);

        // Recuperamos del bundle todos los datos pasados al fragmento
        String fecha = getArguments().getString("fecha");
        String motivo = getArguments().getString("motivo");
        String observaciones = getArguments().getString("observaciones");

        // Obtener referencias de componentes en la vista
        TextView tvFecha = view.findViewById(R.id.tvFecha);
        TextView tvMotivo = view.findViewById(R.id.tvMotivo);
        TextView tvObservaciones = view.findViewById(R.id.tvObservaciones);

        // Mostrar los valores en cada fragmento creado
        tvFecha.setText("Fecha: " + fecha);
        tvMotivo.setText("Motivo: " + motivo);
        tvObservaciones.setText("Observaciones: " + observaciones);

        return view;

    }
}