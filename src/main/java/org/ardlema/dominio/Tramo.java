package org.ardlema.dominio;

import java.awt.geom.Point2D;

public class Tramo {

    private double distancia;

    private final Nodo nodoDestino;

    public Tramo(Nodo nodoDeDestino, int distanciaADestino) {

        distancia =  distanciaADestino;

        nodoDestino = nodoDeDestino;

    }

    public Tramo(Nodo nodoDeOrigen, Nodo nodoDeDestino) {

        distancia = calcularDistancia(nodoDeOrigen, nodoDeDestino);

        nodoDestino = nodoDeDestino;
    }

    public Nodo obtenerNodoDestino() {
        return nodoDestino;
    }

    public double obtenerDistancia() {
        return distancia;
    }

    public static double calcularDistancia(Nodo origen, Nodo destino){
        Point2D puntoOrigen = new Point2D.Double(origen.obtenerCiudad().obtenerCoordenadaX(), origen.obtenerCiudad().obtenerCoordenadaY());
        Point2D puntoDestino = new Point2D.Double(destino.obtenerCiudad().obtenerCoordenadaX(), destino.obtenerCiudad().obtenerCoordenadaY());

        return puntoOrigen.distance(puntoDestino);

    }
}