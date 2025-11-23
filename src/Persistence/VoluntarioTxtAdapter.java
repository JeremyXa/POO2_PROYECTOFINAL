package persistence;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import model.Localidad;
import model.TareaVoluntario;
import model.Voluntario;

public class VoluntarioTxtAdapter {

    private final Path archivo;

    public VoluntarioTxtAdapter(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
    }

    public void guardarRegistro(Voluntario v, TareaVoluntario tarea) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(archivo,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            // codigo;nombre;telefono;dni;edad;correo;localidad;tarea
            bw.write(String.join(";",
                    v.getCodigo(),
                    v.getNombreCompleto(),
                    v.getTelefono(),
                    v.getDni(),
                    String.valueOf(v.getEdad()),
                    v.getCorreo(),
                    tarea.getLocalidad().getNombre(),
                    tarea.getDescripcionTarea()));
            bw.newLine();
        }
    }

    public List<String[]> cargarTodos() throws IOException {
        List<String[]> lista = new ArrayList<>();
        if (!Files.exists(archivo)) return lista;

        try (BufferedReader br = Files.newBufferedReader(archivo)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea.split(";"));
            }
        }
        return lista;
    }
}
