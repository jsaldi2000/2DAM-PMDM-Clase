package com.example.intentsenviardatosobjetosparcelable.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {

    private String nombre;
    private int edad;

    // Constructor vacío
    public Persona() {
    }

    // Al implementar el interface Parcelable habrá que implementar un par de métodos en la clase, describeContents
    @Override
    public int describeContents() {
        return 0;
    }

    // y el método writeToParcel que recibe un objeto Parcel de destino y un flag que puede ser 0 PARCELABLE_WRITE_RETURN_VALUE.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
    }

    // Añadimos un constructor que reciba un Parcel
    public Persona(Parcel in) {
        readFromParcel(in);
    }

    // Y definimos el método readFromParcel()
    private void readFromParcel(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
    }


    // Solo nos queda definir el CREATOR que nos va a permitir crear listas tipadas
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
