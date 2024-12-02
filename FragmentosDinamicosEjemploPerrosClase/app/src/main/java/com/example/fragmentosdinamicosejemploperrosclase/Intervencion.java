package com.example.fragmentosdinamicosejemploperrosclase;

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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
