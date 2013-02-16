package org.ardlema.parser;

import org.ardlema.dominio.Carretera;
import org.ardlema.dominio.Ciudad;
import org.ardlema.dominio.Mapa;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonFileParser implements StrategyParser {

    public Mapa obtenerMapa(InputStream is) {
        Mapa mapa = new Mapa();

        JsonFactory f = new MappingJsonFactory();

        try {
            JsonParser jp = f.createJsonParser(is);

            JsonToken current;

            current = jp.nextToken();

            while (jp.nextToken() != JsonToken.END_OBJECT) {

                String fieldName = jp.getCurrentName();

                current = jp.nextToken();
                if (fieldName.equals("ciudades")) {
                    List<Ciudad> ciudades = new ArrayList<Ciudad>();
                    if (current == JsonToken.START_ARRAY) {

                        while (jp.nextToken() != JsonToken.END_ARRAY) {

                            JsonNode node = jp.readValueAsTree();
                            Ciudad ciudad = new Ciudad(node.get("nombre").asText(),node.get("coordenadaX").asInt(),node.get("coordenadaY").asInt());
                            ciudades.add(ciudad);

                        }

                        mapa.setCiudades(ciudades);

                    } else {
                        System.out.println("Error: las ciudades deben ser un array.");
                        jp.skipChildren();
                    }
                } else if (fieldName.equals("carreteras")) {
                    List<Carretera> carreteras = new ArrayList<Carretera>();

                    if (current == JsonToken.START_ARRAY) {

                        while (jp.nextToken() != JsonToken.END_ARRAY) {

                            JsonNode node = jp.readValueAsTree();

                            Carretera carretera = new Carretera(node.get("origen").asText(),node.get("destino").asText());

                            carreteras.add(carretera);
                        }

                        mapa.setCarreteras(carreteras);
                    } else {
                        System.out.println("Error: las carreteras deben ser un array.");
                        jp.skipChildren();
                    }
                }
            }
        } catch(IOException e){
            System.out.println("IOException");

        }

        return mapa;
    }


}
