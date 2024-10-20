package com.example.lenguajesdeprogramacion.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Lenguaje> lenguajes;
    private int currentIndex;

    public DataManager() {
        lenguajes = new ArrayList<>();
        lenguajes.add(new Lenguaje("Java", "Java es un lenguaje de programación orientado a objetos... "));
        lenguajes.add(new Lenguaje("Python", "Python es un lenguaje de programación interpretado..."));
        lenguajes.add(new Lenguaje("C++", "C++ es un lenguaje de programación de propósito general..."));
        lenguajes.add(new Lenguaje("JavaScript", "JavaScript es un lenguaje de programación interpretado que se utiliza principalmente para el desarrollo web..."));
        lenguajes.add(new Lenguaje("Kotlin", "Kotlin es un lenguaje de programación moderno, estáticamente tipado y orientado a objetos que está diseñado para ser totalmente interoperable con Java"));
        currentIndex = 0;
    }

    public Lenguaje getLenguajeActual() {
        return lenguajes.get(currentIndex);
    }

    public void siguienteLenguaje() {
        currentIndex = (currentIndex + 1) % lenguajes.size(); //Forma de resetear la lista. Con % calculo el resto de la división
    }
}
