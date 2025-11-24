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
        Files.createDirectories(filePath.getParent());
        Files.write(
                filePath,
                (line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    protected List<String> readAllLines() throws IOException {
        if (Files.notExists(filePath)) {
            return new ArrayList<>();
        }
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }

    protected void writeAllLines(List<String> lines) throws IOException {
        Files.createDirectories(filePath.getParent());
        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    protected Path getFilePath() {
        return filePath;
    }
}
