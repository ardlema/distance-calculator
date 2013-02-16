package org.ardlema.parser;


import org.ardlema.dominio.Mapa;

import java.io.InputStream;

public class StrategyContext {

   private StrategyParser strategy;

   public StrategyContext(StrategyParser strategy) {
       this.strategy = strategy;
   }

   public Mapa executeStrategy(InputStream is) {
      return strategy.obtenerMapa(is);
   }

}
