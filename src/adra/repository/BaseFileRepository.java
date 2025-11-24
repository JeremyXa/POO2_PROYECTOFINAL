package adra.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public abstract class BaseFileRepository {

    protected final Path filePath;

    public BaseFileRepository(String filePath) {
        this.filePath = Paths.get(filePath);
        initFile();
    }

    private void initFile() {
        try {
            // Crear carpeta si no existe
            Path parent = filePath.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            // Crear archivo vacío si no existe
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar el archivo: " + filePath, e);
        }
    }

    protected void appendLine(String line) throws IOException {
        Files.write(
                filePath,
                (line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND
        );
    }

    protected List<String> readAllLines() throws IOException {
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }

    protected void writeAllLines(List<String> lines) throws IOException {
        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
