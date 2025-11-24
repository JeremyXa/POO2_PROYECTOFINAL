package adra.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFileRepository {

    private final Path filePath;

    protected BaseFileRepository(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    protected void appendLine(String line) throws IOException {
        // Crear carpeta si no existe (por ejemplo "data")
        Path parent = filePath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        Files.write(
                filePath,
                (line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    protected List<String> readAllLines() throws IOException {
        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }

    protected void writeAllLines(List<String> lines) throws IOException {
        Path parent = filePath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
