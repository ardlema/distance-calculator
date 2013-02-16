package org.ardlema.dominio;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
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

    public String imprimirCiudadesDePaso() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("[ ");
        String separacion = "";
        for (Ciudad ciudad: obtenerCiudadesDePaso()) {
            strBuilder.append(separacion);
            strBuilder.append(ciudad.obtenerNombreCiudad());
            separacion = " -> ";
        }
        strBuilder.append(" ]");
        return strBuilder.toString();

    }
}
