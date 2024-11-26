package com.example.fragmentosestaticosclase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TituloFragment extends Fragment {

    // Creamos un constructor vacío, requerido por Android para la recreación de fragmento
    public TituloFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        return inflater.inflate(R.layout.fragment_titulo, container, false);
    }

}