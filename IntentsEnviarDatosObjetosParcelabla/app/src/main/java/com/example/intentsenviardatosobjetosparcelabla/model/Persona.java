package com.example.intentsenviardatosobjetosparcelabla.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Persona implements Parcelable {

    private String nombre;
    private int edad;

    // Constructor parametrizado
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Constructor vacío
    public Persona() {
    }


    // Constructor que recibe un parcel
    protected Persona(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
    }

    // Definir el CREATOR que nos va a permitir crear listas tipadas
    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    // Al implementar el interface Parcelable habrá que implementar un par de métodos en la clase, describeContents
    @Override
    public int describeContents() {
        return 0;
    }

    // y el método writeToParcel que recibe un objeto Parcel de destino y un flag que puede ser 0 PARCELABLE_WRITE_RETURN_VALUE.
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
