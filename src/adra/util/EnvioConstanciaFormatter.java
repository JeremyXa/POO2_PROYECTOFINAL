package adra.service;

import adra.model.Donacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EnvioConstanciaFormatter {

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String generarConstancia(List<Donacion> donaciones,
                                    String destinatario,
                                    String destinoEnvio,
                                    String conductor) {

        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("================================").append(nl);
        sb.append("CONSTANCIA DE ENVÍO - ADRA").append(nl);
        sb.append("Fecha generación: ")
          .append(LocalDateTime.now().format(dateTimeFormatter)).append(nl);
        sb.append("Destinatario: ").append(destinatario).append(nl);
        sb.append("Destino de envío: ").append(destinoEnvio).append(nl);
        sb.append("Conductor: ").append(conductor).append(nl);
        sb.append(nl);
        sb.append("Donaciones:").append(nl);

        for (Donacion d : donaciones) {
            sb.append("- [").append(d.getCodigo()).append("] ")
              .append(d.getDescripcion())
              .append(" (").append(d.getCantidad()).append(") ")
              .append(d.getDonante())
              .append(" [").append(d.getTipo().name()).append("]").append(nl);
        }

        sb.append("================================").append(nl).append(nl);
        return sb.toString();
    }
}
