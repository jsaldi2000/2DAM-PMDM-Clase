package com.example.fragmentosdinamicosejemploperros;

import java.util.ArrayList;
import java.util.List;

public class Perro {

    private String nombre;

    // Lista de intervenciones veterinarias asociadas al perro
    private List<Intervencion> intervenciones;

    public Perro(String nombre) {
        this.nombre = nombre; // Asigna el nombre proporcionado al atributo 'nombre'
        this.intervenciones = new ArrayList<>(); // Inicializa la lista de intervenciones como vacía
    }

    public String getNombre() {
        return nombre; // Devuelve el valor del atributo 'nombre'
    }

    public List<Intervencion> getIntervenciones() {
        return intervenciones; // Devuelve la lista de intervenciones
    }

    public void addIntervencion(String fecha, String motivo, String observaciones) {
        // Crea un nuevo objeto Intervencion y lo añade a la lista
        intervenciones.add(new Intervencion(fecha, motivo, observaciones));
    }
}
