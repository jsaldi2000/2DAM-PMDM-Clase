package com.example.hechoscuriosos3;

import android.graphics.Color;

public class ColoresFondo {
    private String[] colores = {
            "#39add1", "#3079ab", "#c25975", "#e15258", "#f9845b",
            "#838cc7", "#7d669e", "#53bbb4", "#51b46d", "#e0ab18"
    };

    public int getColorAleatorio() {
        int randomIndex = (int) (Math.random() * colores.length);
        return Color.parseColor(colores[randomIndex]);
    }
}
