package org.ardlema.dominio;

public class Nodo implements Comparable<Nodo>
{
    public final Ciudad ciudad;

    private int minimaDistancica = Integer.MAX_VALUE;

    public Tramo[] nodosVecinos;

    public Nodo nodoAnterior;

    public Nodo(Ciudad ciudadDelNodo) {
        ciudad = ciudadDelNodo;
    }

    public void establecerMinimaDistancia(int minima) {
        minimaDistancica = minima;
    }

    public int obtenerMinimaDistancia() {
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

    public int compareTo(Nodo other)
    {
        return new Integer(minimaDistancica).compareTo(other.minimaDistancica);
    }
}
