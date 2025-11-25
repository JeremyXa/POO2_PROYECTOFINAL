package adra.repository;

import adra.model.Donacion;
import adra.model.TipoDonacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DonacionFileRepositoryAdapter extends BaseFileRepository
        implements DonacionRepository {

    public DonacionFileRepositoryAdapter(String filePath) {
        super(filePath);
    }

    @Override
    public void save(Donacion donacion) throws IOException {
        appendLine(encode(donacion));
    }

    @Override
    public List<Donacion> findAll() throws IOException {
        List<String> lines = readAllLines();
        List<Donacion> resultado = new ArrayList<>();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                resultado.add(decode(line));
            }
        }
        return resultado;
    }

    @Override
    public List<Donacion> findByCodigo(String codigo) throws IOException {
        String buscado = codigo.toLowerCase();
        return findAll().stream()
                .filter(d -> d.getCodigo() != null &&
                        d.getCodigo().toLowerCase().contains(buscado))
                .collect(Collectors.toList());
    }

    @Override
    public List<Donacion> findByDonante(String donante) throws IOException {
        String buscado = donante.toLowerCase();
        return findAll().stream()
                .filter(d -> d.getDonante() != null &&
                        d.getDonante().toLowerCase().contains(buscado))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Donacion donacion) throws IOException {
        List<Donacion> todas = findAll();
        for (int i = 0; i < todas.size(); i++) {
            if (todas.get(i).getCodigo().equalsIgnoreCase(donacion.getCodigo())) {
                todas.set(i, donacion);
                break;
            }
        }
        List<String> lines = new ArrayList<>();
        for (Donacion d : todas) {
            lines.add(encode(d));
        }
        writeAllLines(lines);
    }

    @Override
    public void deleteByCodigo(String codigo) throws IOException {
        List<Donacion> todas = findAll();
        String buscado = codigo.toLowerCase();
        List<String> lines = new ArrayList<>();
        for (Donacion d : todas) {
            if (!d.getCodigo().toLowerCase().equals(buscado)) {
                lines.add(encode(d));
            }
        }
        writeAllLines(lines);
    }

    private String encode(Donacion d) {
        return d.getCodigo() + "|" +
               d.getDescripcion() + "|" +
               d.getFechaIngreso() + "|" +
               d.getCantidad() + "|" +
               d.getDonante() + "|" +
               d.getTipo().name();
    }

    private Donacion decode(String line) {
        String[] parts = line.split("\\|");
        String codigo = parts.length > 0 ? parts[0] : "";
        String descripcion = parts.length > 1 ? parts[1] : "";
        String fecha = parts.length > 2 ? parts[2] : "";
        int cantidad = 0;
        if (parts.length > 3) {
            try { cantidad = Integer.parseInt(parts[3]); } catch (NumberFormatException ignored) {}
        }
        String donante = parts.length > 4 ? parts[4] : "";
        TipoDonacion tipo = parts.length > 5
                ? TipoDonacion.fromString(parts[5])
                : TipoDonacion.fromCodigoDonacion(codigo);

        return new Donacion(codigo, descripcion, fecha, cantidad, donante, tipo);
    }
}
