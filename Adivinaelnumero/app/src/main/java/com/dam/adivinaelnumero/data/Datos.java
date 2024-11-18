package com.dam.adivinaelnumero.data;

import java.util.Random;

public class Datos {
    public static final int NUM_INTENTOS = 5;
    public static final int MIN = 1;
    public static final int MAX = 100;

    public static int generarNumSecreto() {
        Random rd = new Random();
        return rd.nextInt(MAX - MIN + 1) + MIN; // rd.nextInt cogería entre 0 y 99, si le sumamos el MIN, tenemos entre 1 y 100.
    }
}
