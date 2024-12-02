package com.example.fragmentosdinamicosejemploperros;

import java.util.ArrayList;
import java.util.List;

public class PerrosDatos {

    private List<Perro> perros; // Lista de todos los perros con sus datos

    public PerrosDatos() {
        this.perros = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        Perro rex = new Perro("Rex");
        rex.addIntervencion("01/01/2022", "Vacunación", "Aplicación de vacuna antirrábica.");
        rex.addIntervencion("15/02/2022", "Chequeo General", "Revisión completa, sin anomalías.");
        rex.addIntervencion("10/03/2022", "Desparasitación", "Administración de antiparasitarios internos.");
        perros.add(rex);

        Perro tor = new Perro("Tor");
        tor.addIntervencion("05/04/2022", "Radiografía", "Fractura en la pata delantera derecha.");
        tor.addIntervencion("20/04/2022", "Cirugía", "Reparación quirúrgica de la fractura.");
        perros.add(tor);

        Perro jambo = new Perro("Jambo");
        jambo.addIntervencion("12/07/2021", "Vacunación", "Refuerzo de vacuna antirrábica.");
        jambo.addIntervencion("15/08/2021", "Chequeo General", "Peso elevado, recomendación de dieta.");
        perros.add(jambo);
    }

    public Perro getPerroPorNombre(String nombre) {
        for (Perro perro : perros) {
            if (perro.getNombre().equalsIgnoreCase(nombre)) {
                return perro;
            }
        }
        return null; // Devuelve null si no encuentra el perro
    }

    // Método para obtener la lista de nombres de perros (para crear los botones)
    public List<Perro> getNombrePerros() {

        return perros; // Devuelve la lista de perros
    }

}
