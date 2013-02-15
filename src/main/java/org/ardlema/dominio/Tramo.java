package org.ardlema.dominio;

public class Tramo {

    private final int distancia;

    private final Nodo nodoDestino;

    public Tramo(Nodo nodoDeDestino, int distanciaADestino) {

        distancia =  distanciaADestino;

        nodoDestino = nodoDeDestino;

    }

    public Nodo obtenerNodoDestino() {
        return nodoDestino;
    }

    public int obtenerDistancia() {
        return distancia;
    }
}