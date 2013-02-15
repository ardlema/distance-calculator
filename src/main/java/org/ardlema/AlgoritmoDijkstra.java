package org.ardlema;

import org.ardlema.dominio.Nodo;
import org.ardlema.dominio.Tramo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AlgoritmoDijkstra {


    public static void calcularTodosLosPosiblesCaminosDesdeNodoOrigen(Nodo origen)
    {
        origen.establecerMinimaDistancia(0);

        PriorityQueue<Nodo> colaDeNodos = new PriorityQueue<Nodo>();

        colaDeNodos.add(origen);

        while (!colaDeNodos.isEmpty()) {

            Nodo nodo = colaDeNodos.poll();

            for (Tramo tramo : nodo.nodosVecinos)
            {
                Nodo nodoDestino = tramo.obtenerNodoDestino();
                int distanciaDelTramo = tramo.obtenerDistancia();
                int distanceThroughNodo = nodo.obtenerMinimaDistancia() + distanciaDelTramo;
                if (distanceThroughNodo < nodoDestino.obtenerMinimaDistancia()) {
                    colaDeNodos.remove(nodoDestino);
                    nodoDestino.establecerMinimaDistancia(distanceThroughNodo) ;
                    nodoDestino.establecerNodoAnterior(nodo);
                    colaDeNodos.add(nodoDestino);
                }
            }
        }
    }

    public static List<Nodo> obtenerElCaminoMasCortoADestino(Nodo destino)
    {
        List<Nodo> caminoMasCorto = new ArrayList<Nodo>();

        for (Nodo nodo = destino; nodo != null; nodo = nodo.obtenerNodoAnterior())
            caminoMasCorto.add(nodo);

        Collections.reverse(caminoMasCorto);

        return caminoMasCorto;
    }
}
