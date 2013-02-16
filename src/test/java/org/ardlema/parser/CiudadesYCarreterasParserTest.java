package org.ardlema.parser;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.ardlema.dominio.Carretera;
import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Mapa;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;

import java.io.InputStream;
import java.util.List;

public class CiudadesYCarreterasParserTest extends TestCase {


    public CiudadesYCarreterasParserTest(String name) {
        super(name);
    }


    protected void setUp() {

    }

    protected void tearDown() {

    }

    public void testGenerarMapa() {

        InputStream jsonMapFile = getClass().getResourceAsStream("../resources/ciudades_carreteras.json");

        StrategyContext mapContext;

        mapContext = new StrategyContext(new JsonFileParser());

        Mapa mapa = mapContext.executeStrategy(jsonMapFile);

        List<Carretera> carreteras = mapa.getCarreteras();
        List<Ciudad> ciudades = mapa.getCiudades();

        assertEquals(carreteras.size(), 4);
        assertEquals(ciudades.size(), 4);


    }

    public static Test suite() {

        TestSuite suite = new TestSuite(CiudadesYCarreterasParserTest.class);

        return suite;
    }


    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
