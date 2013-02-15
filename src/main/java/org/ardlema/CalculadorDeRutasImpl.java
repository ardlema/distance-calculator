package org.ardlema;

import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Ruta;
import org.ardlema.dominio.Nodo;
import org.ardlema.dominio.Tramo;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeRutasImpl implements CalculadorDeRutas {

    public Ruta obtenerRutaEntreCiudades(String origen, String destino) {
        Ruta ruta = new Ruta();

        Nodo madrid = new Nodo(new Ciudad("Madrid"));
        Nodo valencia = new Nodo(new Ciudad("Valencia"));
        Nodo albacete = new Nodo(new Ciudad("Albacete"));
        Nodo barcelona = new Nodo(new Ciudad("Barcelona"));

        madrid.nodosVecinos = new Tramo[]{ new Tramo(valencia, 350),
                new Tramo(albacete, 250)};

        albacete.nodosVecinos = new Tramo[]{ new Tramo(madrid, 250),
                new Tramo(valencia, 100)};

        valencia.nodosVecinos = new Tramo[]{ new Tramo(madrid, 350),
                new Tramo(albacete, 100),
                new Tramo(barcelona, 350)
        };

        barcelona.nodosVecinos = new Tramo[]{ new Tramo(valencia, 350)};

        Nodo[] nodos = { madrid, valencia, albacete, barcelona };

        Nodo nodoOrigen = obtenerNodoFromString(nodos, origen);

        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(nodoOrigen);

        Nodo nodoDestino = obtenerNodoFromString(nodos,destino);

        ruta.establecerDistanciaTotal(nodoDestino.obtenerMinimaDistancia());

        List<Nodo> ciudadesDePaso = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(nodoDestino);

        ruta.establecerCiudadesDePaso(convertirListaDeNodosAListaDeCiudades(ciudadesDePaso));

        return ruta;
    }



    //TODO Throw exception si no encontramos nodo
    private Nodo obtenerNodoFromString(Nodo[] nodos, String stringNodo) {
        Nodo nodoFromString = null;
        for (Nodo nodo: nodos){
            if (nodo.ciudad.obtenerNombreCiudad().equals(stringNodo))
                nodoFromString = nodo;
        }
        return nodoFromString;
    }

    private List<Ciudad> convertirListaDeNodosAListaDeCiudades(List<Nodo> nodos) {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        for (Nodo nodo: nodos) {
            ciudades.add(nodo.ciudad);
        }

        return ciudades;
    }


}
