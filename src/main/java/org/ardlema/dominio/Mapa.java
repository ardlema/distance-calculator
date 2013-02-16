package org.ardlema.dominio;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public class Mapa {


    private List<Ciudad> ciudades = new ArrayList<Ciudad>();

    private List<Carretera> carreteras = new ArrayList<Carretera>();

    public List<Carretera> getCarreteras() {
        return carreteras;
    }

    public void setCarreteras(List<Carretera> carreteras) {
        this.carreteras = carreteras;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Ciudad> getVecinos(Ciudad ciudad){
        List<Ciudad> ciudadesVecinas = new ArrayList<Ciudad>();

        for (Carretera carretera: getCarreteras()) {

            if (carretera.getOrigen().equals(ciudad.obtenerNombreCiudad()))
                ciudadesVecinas.add(new Ciudad(carretera.getDestino()));
            if (carretera.getDestino().equals(ciudad.obtenerNombreCiudad()))
                ciudadesVecinas.add(new Ciudad(carretera.getOrigen()));

        }


        return ciudadesVecinas;

    }

    public List<Nodo> getNodosVecinos(Ciudad ciudad, List<Nodo> nodos){
        List<Nodo> nodosVecinos = new ArrayList<Nodo>();

        for (Carretera carretera: getCarreteras()) {

            if (carretera.getOrigen().equals(ciudad.obtenerNombreCiudad())) {
                Nodo nodoVecino = findNodoVecino(nodos, new Ciudad(carretera.getDestino()));
                nodosVecinos.add(nodoVecino);
            }
            if (carretera.getDestino().equals(ciudad.obtenerNombreCiudad())) {
                Nodo nodoVecino = findNodoVecino(nodos, new Ciudad(carretera.getOrigen()));
                nodosVecinos.add(nodoVecino);
            }

        }

        return nodosVecinos;

    }

    private Nodo findNodoVecino(List<Nodo> nodos, final Ciudad ciudad) {
        Nodo nodo = Iterables.find(nodos,
                new Predicate<Nodo>() {
                    public boolean apply(Nodo n)
                    {
                        return ciudad.obtenerNombreCiudad().equals(n.obtenerCiudad().obtenerNombreCiudad());
                    }
                });

        return nodo;
    }
}
