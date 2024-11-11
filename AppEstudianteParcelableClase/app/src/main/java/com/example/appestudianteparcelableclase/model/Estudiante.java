package com.example.appestudianteparcelableclase.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Estudiante implements Parcelable {

    private String nombre;
    private int edad;
    private String curso;
    private double notaFinal;


    protected Estudiante(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        curso = in.readString();
        notaFinal = in.readDouble();
    }

    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante>() {
        @Override
        public Estudiante createFromParcel(Parcel in) {
            return new Estudiante(in);
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeString(curso);
        dest.writeDouble(notaFinal);
    }


    public Estudiante(String nombre, int edad, String curso, double notaFinal) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.notaFinal = notaFinal;
    }

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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

}
