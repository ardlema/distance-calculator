package org.ardlema.dominio;

import java.util.List;

public class Nodo implements Comparable<Nodo>
{
    private final Ciudad ciudad;

    private double minimaDistancica = Double.MAX_VALUE;

    private List<Tramo> nodosVecinos;

    private Nodo nodoAnterior;

    public Nodo(Ciudad ciudadDelNodo) {
        ciudad = ciudadDelNodo;
    }

    public void establecerMinimaDistancia(double minima) {
        minimaDistancica = minima;
    }

    public List<Tramo> obtenerNodosVecinos(){
        return nodosVecinos;
    }

    public void establecerNodosVecinos(List<Tramo> vecinos) {
        nodosVecinos = vecinos;
    }

    public double obtenerMinimaDistancia() {
        return minimaDistancica;
    }

    public void establecerNodoAnterior(Nodo nodo) {
        nodoAnterior = nodo;
    }

    public Nodo obtenerNodoAnterior() {
        return nodoAnterior;
    }

    public String toString() {
        return ciudad.obtenerNombreCiudad();
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int compareTo(Nodo other)
    {
        return new Double(minimaDistancica).compareTo(other.minimaDistancica);
    }
}
