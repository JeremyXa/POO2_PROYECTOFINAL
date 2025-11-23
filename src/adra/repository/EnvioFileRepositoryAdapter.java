package adra.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnvioFileRepositoryAdapter implements EnvioRepository {

    private static final Logger logger = Logger.getLogger(EnvioFileRepositoryAdapter.class.getName());

    private final Path archivo;

    public EnvioFileRepositoryAdapter(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
    }

    @Override
    public synchronized void guardarConstancia(String constancia) {
        try {
            if (archivo.getParent() != null) {
                Files.createDirectories(archivo.getParent());
            }
            String texto = constancia + System.lineSeparator()
                    + "----------------------------------------"
                    + System.lineSeparator();
            Files.write(archivo, texto.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error escribiendo constancia de envío", e);
        }
    }
}
