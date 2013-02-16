package org.ardlema;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.ardlema.dominio.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoritmoDijkstraTest extends TestCase {



    public AlgoritmoDijkstraTest(String name) {
        super(name);
    }


    protected void setUp() {

    }

    protected void tearDown() {

    }

    public void testCalcularMinimasDistancias() {
        Nodo madrid = new Nodo(new Ciudad("Madrid"));
        Nodo valencia = new Nodo(new Ciudad("Valencia"));
        Nodo albacete = new Nodo(new Ciudad("Albacete"));
        Nodo barcelona = new Nodo(new Ciudad("Barcelona"));

        List<Tramo> listaTramosMadrid = Arrays.asList(new Tramo(valencia, 350),
                new Tramo(albacete, 250));

        madrid.establecerNodosVecinos(listaTramosMadrid);

        List<Tramo> listaTramosAlbacete = Arrays.asList(new Tramo(madrid, 250),
                new Tramo(albacete, 100));

        albacete.establecerNodosVecinos(listaTramosAlbacete);

        List<Tramo> listaTramosValencia = Arrays.asList(new Tramo(madrid, 350),
                new Tramo(albacete, 100),
                new Tramo(barcelona, 350));
        valencia.establecerNodosVecinos(listaTramosValencia);


        List<Tramo> listaTramosBarcelona = Arrays.asList(new Tramo(valencia, 350));
        barcelona.establecerNodosVecinos(listaTramosBarcelona);

        List<Nodo> listaNodos = new ArrayList<Nodo>();
        listaNodos.add(madrid);
        listaNodos.add(albacete);
        listaNodos.add(valencia);
        listaNodos.add(barcelona);

        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(madrid);

        assertEquals(valencia.obtenerMinimaDistancia(),350.0);
        assertEquals(albacete.obtenerMinimaDistancia(),250.0);
        assertEquals(barcelona.obtenerMinimaDistancia(),700.0);

    }

    public void testCalcularCaminosMasCortosADestino() {
        Nodo madrid = new Nodo(new Ciudad("Madrid"));
        Nodo valencia = new Nodo(new Ciudad("Valencia"));
        Nodo albacete = new Nodo(new Ciudad("Albacete"));
        Nodo barcelona = new Nodo(new Ciudad("Barcelona"));

        List<Tramo> listaTramosMadrid = Arrays.asList(new Tramo(valencia, 350),
                new Tramo(albacete, 250));

        madrid.establecerNodosVecinos(listaTramosMadrid);

        List<Tramo> listaTramosAlbacete = Arrays.asList(new Tramo(madrid, 250),
                new Tramo(albacete, 100));

        albacete.establecerNodosVecinos(listaTramosAlbacete);

        List<Tramo> listaTramosValencia = Arrays.asList(new Tramo(madrid, 350),
                new Tramo(albacete, 100),
                new Tramo(barcelona, 350));
        valencia.establecerNodosVecinos(listaTramosValencia);


        List<Tramo> listaTramosBarcelona = Arrays.asList(new Tramo(valencia, 350));
        barcelona.establecerNodosVecinos(listaTramosBarcelona);


        List<Nodo> listaNodos = new ArrayList<Nodo>();
        listaNodos.add(madrid);
        listaNodos.add(albacete);
        listaNodos.add(valencia);
        listaNodos.add(barcelona);

        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(madrid);

        List<Nodo> nodosDePasoHastaBarcelona = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(listaNodos.get(3));

        assertEquals(3, nodosDePasoHastaBarcelona.size());

        assertEquals(nodosDePasoHastaBarcelona.get(0), madrid);
        assertEquals(nodosDePasoHastaBarcelona.get(1), valencia);
        assertEquals(nodosDePasoHastaBarcelona.get(2), barcelona);

        List<Nodo> nodosDePasoHastaAlbacete = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(albacete);

        assertEquals(2, nodosDePasoHastaAlbacete.size());
        assertEquals(nodosDePasoHastaAlbacete.get(0), madrid);
        assertEquals(nodosDePasoHastaAlbacete.get(1), albacete);
    }


    public static Test suite() {

        TestSuite suite = new TestSuite(AlgoritmoDijkstraTest.class);

        return suite;
    }


    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }

}
