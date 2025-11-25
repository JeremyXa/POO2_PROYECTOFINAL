package adra.model;

import java.util.List;

public class Envio {

    private String codigoEnvio;
    private String destino;
    private String conductor;
    private List<String> codigosDonaciones;

    public Envio(String codigoEnvio, String destino, String conductor,
                 List<String> codigosDonaciones) {
        this.codigoEnvio = codigoEnvio;
        this.destino = destino;
        this.conductor = conductor;
        this.codigosDonaciones = codigosDonaciones;
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public String getConductor() {
        return conductor;
    }

    public List<String> getCodigosDonaciones() {
        return codigosDonaciones;
    }
}
