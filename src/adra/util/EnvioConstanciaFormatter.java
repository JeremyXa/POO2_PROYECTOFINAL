package adra.util;

import adra.model.Donacion;
import adra.model.Envio;

import java.time.format.DateTimeFormatter;

public final class EnvioConstanciaFormatter {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private EnvioConstanciaFormatter() {
        // Utility class
    }

    public static String formatear(Envio envio) {
        StringBuilder sb = new StringBuilder();
        sb.append("********* CONSTANCIA DE ENVÍO *********").append(System.lineSeparator());
        sb.append("ID de envío   : ").append(envio.getId()).append(System.lineSeparator());
        sb.append("Fecha y hora  : ").append(envio.getFechaHora().format(FORMATTER)).append(System.lineSeparator());
        sb.append("Destinatario  : ").append(envio.getDestinatario()).append(System.lineSeparator());
        sb.append("Destino       : ").append(envio.getDestino()).append(System.lineSeparator());
        sb.append("Conductor     : ").append(envio.getConductor()).append(System.lineSeparator());
        sb.append("Donaciones:").append(System.lineSeparator());
        for (Donacion d : envio.getDonaciones()) {
            sb.append(" - ")
              .append(d.getCodigo())
              .append(" | ")
              .append(d.getDescripcion())
              .append(" | Cantidad: ")
              .append(d.getCantidad())
              .append(System.lineSeparator());
        }
        sb.append("****************************************");
        return sb.toString();
    }
}
