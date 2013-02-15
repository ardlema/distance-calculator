package org.ardlema.dominio;

import org.ardlema.dominio.Ciudad;

import java.util.List;

public class Ruta {

    private int distanciaTotal;

    public List<Ciudad> ciudadesDePaso;

    public int obtenerDistanciaTotal() {
         return distanciaTotal;
    }

    public void establecerDistanciaTotal(int distancia) {
       distanciaTotal = distancia;
    }

    public List<Ciudad> obtenerCiudadesDePaso() {
        return ciudadesDePaso;
    }

    public void establecerCiudadesDePaso(List<Ciudad> ciudades) {
        ciudadesDePaso = ciudades;
    }
}
