package adra.repository;

import adra.model.Voluntario;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import adra.model.Voluntario;
import adra.repository.VoluntarioRepository;  // <-- MISMO paquete que se importa en el builder
import java.util.List;
import java.util.Optional;

public class VoluntarioFileRepositoryAdapter implements VoluntarioRepository {

    private static final Logger logger = Logger.getLogger(VoluntarioFileRepositoryAdapter.class.getName());

    private final Path archivo;
    private final List<Voluntario> cache = new ArrayList<>();

    public VoluntarioFileRepositoryAdapter(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        cache.clear();
        if (!Files.exists(archivo)) {
            return;
        }
        try {
            List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
            for (String linea : lineas) {
                if (linea == null || linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";", -1);
                if (partes.length < 7) {
                    continue;
                }
                String codigo = partes[0];
                String nombre = partes[1];
                String telefono = partes[2];
                String dni = partes[3];
                int edad;
                try {
                    edad = Integer.parseInt(partes[4]);
                } catch (NumberFormatException e) {
                    edad = 0;
                }
                String correo = partes[5];
                String tarea = partes[6];
                Voluntario v = new Voluntario(codigo, nombre, telefono, dni, edad, correo, tarea);
                cache.add(v);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error leyendo archivo de voluntarios", e);
        }
    }

    private String noNull(String s) {
        return s == null ? "" : s;
    }

    private String serializar(Voluntario v) {
        return String.join(";",
                noNull(v.getCodigo()),
                noNull(v.getNombreCompleto()),
                noNull(v.getTelefono()),
                noNull(v.getDni()),
                Integer.toString(v.getEdad()),
                noNull(v.getCorreo()),
                noNull(v.getTarea()));
    }

    @Override
    public synchronized void agregar(Voluntario voluntario) {
        if (voluntario == null) {
            return;
        }
        cache.add(voluntario);
        guardarCambios();
    }

    @Override
    public synchronized List<Voluntario> obtenerTodos() {
        return new ArrayList<>(cache);
    }

    @Override
    public synchronized void guardarCambios() {
        try {
            if (archivo.getParent() != null) {
                Files.createDirectories(archivo.getParent());
            }
            List<String> lineas = new ArrayList<>();
            for (Voluntario v : cache) {
                lineas.add(serializar(v));
            }
            Files.write(archivo, lineas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error escribiendo archivo de voluntarios", e);
        }
    }
}
