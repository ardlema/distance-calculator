package org.ardlema.dominio;

import java.util.List;

public class Ruta {

    private double distanciaTotal;

    public List<Ciudad> ciudadesDePaso;

    public double obtenerDistanciaTotal() {
         return distanciaTotal;
    }

    public void establecerDistanciaTotal(double distancia) {
       distanciaTotal = distancia;
    }

    public List<Ciudad> obtenerCiudadesDePaso() {
        return ciudadesDePaso;
    }

    public void establecerCiudadesDePaso(List<Ciudad> ciudades) {
        ciudadesDePaso = ciudades;
    }
}
