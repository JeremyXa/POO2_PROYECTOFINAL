package adra.repository;

import adra.model.Donacion;
import adra.model.TipoDonacion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonacionFileRepositoryAdapter implements DonacionRepository {

    private static final Logger logger = Logger.getLogger(DonacionFileRepositoryAdapter.class.getName());

    private final Path archivo;
    private final List<Donacion> cache = new ArrayList<>();

    public DonacionFileRepositoryAdapter(String rutaArchivo) {
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
                if (partes.length < 5) {
                    continue;
                }
                String codigo = partes[0];
                String donante = partes[1];
                String descripcion = partes[2];
                String fecha = partes[3];
                int cantidad;
                try {
                    cantidad = Integer.parseInt(partes[4]);
                } catch (NumberFormatException e) {
                    cantidad = 0;
                }
                TipoDonacion tipo = TipoDonacion.fromCodigo(codigo);
                Donacion donacion = new Donacion(codigo, donante, descripcion, fecha, cantidad, tipo);
                cache.add(donacion);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error leyendo archivo de donaciones", e);
        }
    }

    private String noNull(String s) {
        return s == null ? "" : s;
    }

    private String serializar(Donacion d) {
        return String.join(";",
                noNull(d.getCodigo()),
                noNull(d.getDonante()),
                noNull(d.getDescripcion()),
                noNull(d.getFechaIngreso()),
                Integer.toString(d.getCantidad()));
    }

    @Override
    public synchronized void agregar(Donacion donacion) {
        if (donacion == null) {
            return;
        }
        Donacion existente = buscarPorCodigo(donacion.getCodigo());
        if (existente != null) {
            actualizar(donacion);
        } else {
            cache.add(donacion);
            guardarCambios();
        }
    }

    @Override
    public synchronized void actualizar(Donacion donacion) {
        if (donacion == null) {
            return;
        }
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getCodigo().equalsIgnoreCase(donacion.getCodigo())) {
                cache.set(i, donacion);
                break;
            }
        }
        guardarCambios();
    }

    @Override
    public synchronized void eliminarPorCodigo(String codigo) {
        if (codigo == null) {
            return;
        }
        cache.removeIf(d -> codigo.equalsIgnoreCase(d.getCodigo()));
        guardarCambios();
    }

    @Override
    public synchronized Donacion buscarPorCodigo(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (Donacion d : cache) {
            if (codigo.equalsIgnoreCase(d.getCodigo())) {
                return d;
            }
        }
        return null;
    }

    @Override
    public synchronized List<Donacion> buscarPorDonante(String donante) {
        if (donante == null) {
            return Collections.emptyList();
        }
        String criterio = donante.toLowerCase();
        List<Donacion> resultado = new ArrayList<>();
        for (Donacion d : cache) {
            if (d.getDonante() != null &&
                    d.getDonante().toLowerCase().contains(criterio)) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    @Override
    public synchronized List<Donacion> obtenerTodas() {
        return new ArrayList<>(cache);
    }

    @Override
    public synchronized void guardarCambios() {
        try {
            if (archivo.getParent() != null) {
                Files.createDirectories(archivo.getParent());
            }
            List<String> lineas = new ArrayList<>();
            for (Donacion d : cache) {
                lineas.add(serializar(d));
            }
            Files.write(archivo, lineas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error escribiendo archivo de donaciones", e);
        }
    }
}
