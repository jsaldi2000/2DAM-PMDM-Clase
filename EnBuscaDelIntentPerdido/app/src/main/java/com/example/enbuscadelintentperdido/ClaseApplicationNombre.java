package com.example.enbuscadelintentperdido;

import android.app.Application;

public class ClaseApplicationNombre extends Application {

    // Inicialización global para almacenar el nombre del jugador
    private String nombre;

    // Método para establecer el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Inicialización global
        nombre = "jugador"; // Valor por defecto inicializado
    }
}