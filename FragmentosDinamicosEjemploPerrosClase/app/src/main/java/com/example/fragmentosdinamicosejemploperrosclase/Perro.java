package com.example.fragmentosdinamicosejemploperrosclase;

import java.util.ArrayList;
import java.util.List;

public class Perro {

    private String nombre;

    // Lista de intervenciones veterinarias asociadas al perro
    private List<Intervencion> intervenciones;

    public Perro(String nombre) {
        this.nombre = nombre;
        this.intervenciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void addIntervencion(String fecha, String motivo, String observaciones){
        intervenciones.add(new Intervencion(fecha, motivo, observaciones));
    }

}
