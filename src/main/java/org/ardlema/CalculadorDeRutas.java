package org.ardlema;


import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Ruta;

import java.util.List;

public interface CalculadorDeRutas {

    public Ruta obtenerRutaEntreCiudades(String origen, String destino);

    public List<Ciudad> obtenerCiudadesDisponiblesEnElMapa();

}
