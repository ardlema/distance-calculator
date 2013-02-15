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
        ciudadesEntreMadridYBarcelona.add(new Ciudad("Zaragoza"));
        ciudadesEntreMadridYBarcelona.add(new Ciudad("Barcelona"));

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Madrid","Barcelona");

        assertEquals(ruta.obtenerDistanciaTotal(), 600);
        assertEquals(ruta.obtenerCiudadesDePaso(),ciudadesEntreMadridYBarcelona);

    }


    public static Test suite() {

        TestSuite suite = new TestSuite(CalculadorDeRutasImplTest.class);

        return suite;
    }


    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
