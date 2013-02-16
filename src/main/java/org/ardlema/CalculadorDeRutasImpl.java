package org.ardlema;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.ardlema.dominio.*;
import org.ardlema.parser.JsonFileParser;
import org.ardlema.parser.StrategyContext;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CalculadorDeRutasImpl implements CalculadorDeRutas {

    public Ruta obtenerRutaEntreCiudades(String origen, String destino) {
        Ruta ruta = new Ruta();

        Mapa mapa = getMapaFromJson();

        List<Nodo> nodos = obtenerNodos(mapa);

        Nodo nodoOrigen = obtenerNodoFromString(nodos, origen);

        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(nodoOrigen);

        Nodo nodoDestino = obtenerNodoFromString(nodos,destino);

        List<Nodo> ciudadesDePaso = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(nodoDestino);

        ruta.establecerDistanciaTotal(nodoDestino.obtenerMinimaDistancia());
        ruta.establecerCiudadesDePaso(convertirListaDeNodosAListaDeCiudades(ciudadesDePaso));

        return ruta;
    }



    //TODO Throw exception si no encontramos nodo
    private Nodo obtenerNodoFromString(List<Nodo> nodos, String stringCiudad) {
        final Ciudad ciudad = new Ciudad(stringCiudad);

        Nodo nodo = Iterables.find(nodos,
                new Predicate<Nodo>() {
                    public boolean apply(Nodo n)
                    {
                        return ciudad.obtenerNombreCiudad().equals(n.obtenerCiudad().obtenerNombreCiudad());
                    }
                });

        return nodo;


    }

    private List<Ciudad> convertirListaDeNodosAListaDeCiudades(List<Nodo> nodos) {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        for (Nodo nodo: nodos) {
            ciudades.add(nodo.obtenerCiudad());
        }

        return ciudades;
    }


    private List<Nodo> obtenerNodos(Mapa mapa) {

        List<Nodo> nuevoNodos = new ArrayList<Nodo>();

        List<Ciudad> ciudades = mapa.getCiudades();

        for(Ciudad ciudad: ciudades) {
            nuevoNodos.add(new Nodo(ciudad));
        }

        for(Nodo nodo: nuevoNodos) {

            List<Nodo> nodosVecinos = mapa.getNodosVecinos(nodo.obtenerCiudad(), nuevoNodos);

            List<Tramo> tramos = new ArrayList<Tramo>();
            for(Nodo nodoVecino: nodosVecinos) {
               tramos.add(new Tramo(nodo, nodoVecino));

            }
            nodo.establecerNodosVecinos(tramos);
        }

        return nuevoNodos;
    }

    private Mapa getMapaFromJson(){
        InputStream jsonMapFile = getClass().getResourceAsStream("/org/ardlema/resources/ciudades_carreteras.json");

        StrategyContext mapContext;

        mapContext = new StrategyContext(new JsonFileParser());

        return mapContext.executeStrategy(jsonMapFile);

    }

}
