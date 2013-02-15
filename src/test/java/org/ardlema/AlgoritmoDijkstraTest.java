package org.ardlema;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Nodo;
import org.ardlema.dominio.Ruta;
import org.ardlema.dominio.Tramo;

import java.util.ArrayList;
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

        madrid.nodosVecinos = new Tramo[]{ new Tramo(valencia, 350),
                new Tramo(albacete, 250)};

        albacete.nodosVecinos = new Tramo[]{ new Tramo(madrid, 250),
                new Tramo(valencia, 100)};

        valencia.nodosVecinos = new Tramo[]{ new Tramo(madrid, 350),
                new Tramo(albacete, 100),
                new Tramo(barcelona, 350)
        };

        barcelona.nodosVecinos = new Tramo[]{ new Tramo(valencia, 350)};


        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(madrid);

        assertEquals(valencia.obtenerMinimaDistancia(),350);
        assertEquals(albacete.obtenerMinimaDistancia(),250);
        assertEquals(barcelona.obtenerMinimaDistancia(),700);

    }

    public void testCalcularCaminosMasCortosADestino() {
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

        AlgoritmoDijkstra.calcularTodosLosPosiblesCaminosDesdeNodoOrigen(madrid);

        List<Nodo> nodosDePasoHastaBarcelona = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(barcelona);

        assertEquals(nodosDePasoHastaBarcelona.size(), 3);

        assertEquals(nodosDePasoHastaBarcelona.get(0), madrid);
        assertEquals(nodosDePasoHastaBarcelona.get(1), valencia);
        assertEquals(nodosDePasoHastaBarcelona.get(2), barcelona);

        List<Nodo> nodosDePasoHastaAlbacete = AlgoritmoDijkstra.obtenerElCaminoMasCortoADestino(albacete);

        assertEquals(nodosDePasoHastaAlbacete.size(), 2);
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
