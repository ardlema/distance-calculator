package org.ardlema;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Ruta;
import org.ardlema.excepciones.CalculadorDeRutasException;

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

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Madrid","Barcelona");


        assertEquals(400.0, ruta.obtenerDistanciaTotal());
        assertEquals(3, ruta.obtenerCiudadesDePaso().size());

    }

    public void testRutaEntreMadridYAlbacete() {

        CalculadorDeRutas calculadorDeRutas = new CalculadorDeRutasImpl();

        Ruta ruta;

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Madrid","Albacete");


        assertEquals(141.4213562373095, ruta.obtenerDistanciaTotal());
        assertEquals(2, ruta.obtenerCiudadesDePaso().size());

    }

    public void testRutaEntreAlbaceteYBarcelona() {

        CalculadorDeRutas calculadorDeRutas = new CalculadorDeRutasImpl();

        Ruta ruta;

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Albacete","Barcelona");


        assertEquals(341.4213562373095, ruta.obtenerDistanciaTotal());
        assertEquals(3, ruta.obtenerCiudadesDePaso().size());

    }

    public void testRutaEntreValenciaYMadrid() {

        CalculadorDeRutas calculadorDeRutas = new CalculadorDeRutasImpl();

        Ruta ruta;

        ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Valencia","Madrid");


        assertEquals(200.0, ruta.obtenerDistanciaTotal());
        assertEquals(2, ruta.obtenerCiudadesDePaso().size());

    }

    public void testRutaEntreMadridYCiudadDesconocida() {

        CalculadorDeRutas calculadorDeRutas = new CalculadorDeRutasImpl();

        Ruta ruta;

        try {
           ruta = calculadorDeRutas.obtenerRutaEntreCiudades("Madrid","Cuenca");
           fail("Deberia haber lanzado una CalculadorDeRutasExcepcion");
        } catch (CalculadorDeRutasException excepcion) {
           assertTrue(true);
        }

    }


    public static Test suite() {

        TestSuite suite = new TestSuite(CalculadorDeRutasImplTest.class);

        return suite;
    }


    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
