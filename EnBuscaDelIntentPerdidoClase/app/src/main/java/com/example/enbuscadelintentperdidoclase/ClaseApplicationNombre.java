package com.example.enbuscadelintentperdidoclase;

import android.app.Application;

public class ClaseApplicationNombre extends Application {

    // Inicializar globalmente la variable "nombre" (la que pido al jugador al inicio)
    private String nombre;

    // Método para establecer el nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // Método para obtener el nombre
    public String getNombre(){
        return nombre;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        // Inicialización global de la variable "nombre" del jugador
        nombre = "jugador";

    }

}
