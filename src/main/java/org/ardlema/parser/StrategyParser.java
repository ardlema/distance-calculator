package org.ardlema.parser;

import org.ardlema.dominio.Mapa;

import java.io.InputStream;

public interface StrategyParser {

    public Mapa obtenerMapa(InputStream is);
}
