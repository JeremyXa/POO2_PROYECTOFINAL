package persistence;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import model.Donacion;
import model.Donante;

public class DonacionTxtAdapter implements DonacionRepository {

    private final Path archivo;

    public DonacionTxtAdapter(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
    }

    @Override
    public Map<String, Donacion> cargarTodas() throws IOException {
        Map<String, Donacion> mapa = new HashMap<>();

        if (!Files.exists(archivo)) {
            return mapa;
        }

        try (BufferedReader br = Files.newBufferedReader(archivo)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // formato: codigo;nombre;descripcion;cantidad;tipo;donante
                String[] partes = linea.split(";");
                if (partes.length == 6) {
                    String codigo = partes[0];
                    String nombre = partes[1];
                    String descr = partes[2];
                    int cantidad = Integer.parseInt(partes[3]);
                    String tipo = partes[4];
                    String nombreDonante = partes[5];

                    Donante donante = new Donante(nombreDonante);
                    Donacion d = new Donacion(codigo, nombre, descr, cantidad, tipo, donante);
                    mapa.put(codigo, d);
                }
            }
        }
        return mapa;
    }

    @Override
    public void guardarTodas(Map<String, Donacion> donaciones) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(archivo)) {
            for (Donacion d : donaciones.values()) {
                bw.write(formatear(d));
                bw.newLine();
            }
        }
    }

    @Override
    public void guardarNueva(Donacion d) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(archivo,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            bw.write(formatear(d));
            bw.newLine();
        }
    }

    @Override
    public void eliminar(String codigo) throws IOException {
        Map<String, Donacion> mapa = cargarTodas();
        mapa.remove(codigo);
        guardarTodas(mapa);
    }

    private String formatear(Donacion d) {
        return String.join(";", d.getCodigo(),
                d.getNombre(),
                d.getDescripcion(),
                String.valueOf(d.getCantidad()),
                d.getTipo(),
                d.getDonante().getNombre());
    }
}
