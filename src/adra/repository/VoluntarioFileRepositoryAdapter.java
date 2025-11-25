package adra.repository;

import adra.model.Voluntario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioFileRepositoryAdapter extends BaseFileRepository
        implements VoluntarioRepository {

    public VoluntarioFileRepositoryAdapter(String filePath) {
        super(filePath);
    }

    @Override
    public void save(Voluntario voluntario) throws IOException {
        appendLine(encode(voluntario));
    }

    @Override
    public List<Voluntario> findAll() throws IOException {
        List<String> lines = readAllLines();
        List<Voluntario> resultado = new ArrayList<>();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                resultado.add(decode(line));
            }
        }
        return resultado;
    }

    private String encode(Voluntario v) {
        return v.getCodigo() + "|" +
               v.getNombre() + "|" +
               v.getTelefono() + "|" +
               v.getDni() + "|" +
               v.getEdad() + "|" +
               v.getCorreo() + "|" +
               v.getTarea();
    }

    private Voluntario decode(String line) {
        String[] p = line.split("\\|");
        String codigo   = p.length > 0 ? p[0] : "";
        String nombre   = p.length > 1 ? p[1] : "";
        String telefono = p.length > 2 ? p[2] : "";
        String dni      = p.length > 3 ? p[3] : "";
        int edad        = 0;
        if (p.length > 4) {
            try { edad = Integer.parseInt(p[4]); } catch (NumberFormatException ignored) {}
        }
        String correo   = p.length > 5 ? p[5] : "";
        String tarea    = p.length > 6 ? p[6] : "";

        return new Voluntario(codigo, nombre, telefono, dni, edad, correo, tarea);
    }
}
