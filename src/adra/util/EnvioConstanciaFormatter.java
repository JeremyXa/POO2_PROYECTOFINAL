package adra.service;

import adra.model.Donacion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EnvioConstanciaFormatter {

    private final Path filePath;

    public EnvioConstanciaFormatter(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    /**
     * Genera el texto de la constancia y lo guarda (append) en el TXT.
     */
    public void generarYGuardarConstancia(List<Donacion> donaciones,
                                          String destinatario,
                                          String destinoEnvio,
                                          String conductor) throws IOException {

        // Asegura que exista la carpeta
        if (filePath.getParent() != null && Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("===== CONSTANCIA DE ENVÍO =====").append(nl);
        sb.append("Fecha: ")
          .append(LocalDateTime.now().format(
                  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
          )).append(nl);
        sb.append("Destinatario: ").append(destinatario).append(nl);
        sb.append("Destino de envío: ").append(destinoEnvio).append(nl);
        sb.append("Conductor: ").append(conductor).append(nl);
        sb.append("Donaciones:").append(nl);

        for (Donacion d : donaciones) {
            sb.append("  - ")
              .append(d.getCodigo()).append(" | ")
              .append(d.getDescripcion()).append(" | ")
              .append(d.getCantidad()).append(" | ")
              .append(d.getDonante()).append(" | ")
              .append(d.getTipo().name())
              .append(nl);
        }

        sb.append("----------------------------------------").append(nl).append(nl);

        Files.write(
                filePath,
                sb.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
