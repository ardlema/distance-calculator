package org.ardlema.dominio;

public class Ciudad {

    private String nombre;

    private int coordenadaX;

    private int coordenadaY;

    public Ciudad(String nombreCiudad) {
        nombre = nombreCiudad;
    }

    public Ciudad(String nombreCiudad, int coordX, int coordY) {
        nombre = nombreCiudad;
        coordenadaX = coordX;
        coordenadaY = coordY;
    }


    public String obtenerNombreCiudad() {
        return nombre;
    }

    public int obtenerCoordenadaX() {
        return coordenadaX;
    }

    public int obtenerCoordenadaY() {
        return coordenadaY;
    }

}
