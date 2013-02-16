package org.ardlema.dominio;

public class Carretera {

    private String origen;

    private String destino;

    public Carretera(String org, String dest) {
        origen = org;
        destino = dest;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


}
