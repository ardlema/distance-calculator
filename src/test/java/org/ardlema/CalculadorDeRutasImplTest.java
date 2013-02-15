package org.ardlema;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Ruta;

import java.util.ArrayList;
import java.util.List;


public class CalculadorDeRutasImplTest extends TestCase {


    public CalculadorDeRutasImplTest(String name) {
        super(name);
    }


    protected void setUp() {

    }

    protected void tearDown() {

    }

    public void testRutaEntreMadridYBarcelona() {

        CalculadorDeRutas calculadorDeRutas = new CalculadorDeRutasImpl();

        Ruta ruta;

        List<Ciudad> ciudadesEntreMadridYBarcelona = new ArrayList<Ciudad>();

        ciudadesEntreMadridYBarcelona.add(new Ciudad("Madrid"));
        ciudadesEntreMadridYBarcelona.add(new Ciudad("Valencia"));
        ciudadesEntreMadridYBarcelona.add(new Ciudad("Barcelona"));

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Madrid","Barcelona");

        assertEquals(ruta.obtenerDistanciaTotal(), 700);
        assertEquals(ruta.obtenerCiudadesDePaso().size(), 3);

    }


    public static Test suite() {

        TestSuite suite = new TestSuite(CalculadorDeRutasImplTest.class);

        return suite;
    }


    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
