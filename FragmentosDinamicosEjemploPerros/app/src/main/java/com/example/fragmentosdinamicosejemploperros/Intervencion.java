package com.example.fragmentosdinamicosejemploperros;

public class Intervencion {

    private String fecha;
    private String motivo;
    private String observaciones;

    public Intervencion(String fecha, String motivo, String observaciones) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
