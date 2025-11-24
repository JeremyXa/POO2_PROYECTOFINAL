package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.observer.NotificationObserver;
import adra.repository.DonacionRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DonacionService {

    private final DonacionRepository repository;
    private final NotificationObserver observer;

    public DonacionService(DonacionRepository repository, NotificationObserver observer) {
        this.repository = repository;
        this.observer = observer;
    }

    public ResultadoOperacion registrarDonacion(Donacion donacion) {
        if (donacion == null) {
            return ResultadoOperacion.error("La donación no puede ser nula.");
        }

        try {
            repository.save(donacion);

            if (observer != null) {
                observer.notificar("Se registró donación con código " + donacion.getCodigo());
            }

            return ResultadoOperacion.exito("Donación registrada correctamente.");
        } catch (IOException e) {
            return ResultadoOperacion.error("Error al guardar la donación: " + e.getMessage());
        }
    }

    public List<Donacion> listarDonaciones() throws IOException {
        return repository.findAll();
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) throws IOException {
        if (codigo == null || codigo.isBlank()) {
            return listarDonaciones();
        }
        return repository.findByCodigo(codigo);
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) throws IOException {
        if (donante == null || donante.isBlank()) {
            return listarDonaciones();
        }
        return repository.findByDonante(donante);
    }

    /**
     * Búsqueda combinada por código y donante (la que usa la interfaz de Envío/Visualización).
     */
    public List<Donacion> buscarDonaciones(String codigo, String donante) throws IOException {
        String cod = codigo == null ? "" : codigo.trim().toLowerCase();
        String don = donante == null ? "" : donante.trim().toLowerCase();

        List<Donacion> todas = repository.findAll();
        if (cod.isEmpty() && don.isEmpty()) {
            return todas;
        }

        List<Donacion> resultado = new ArrayList<>();
        for (Donacion d : todas) {
            boolean coincide = true;

            // filtro por código
            if (!cod.isEmpty()) {
                coincide = d.getCodigo() != null &&
                           d.getCodigo().toLowerCase().contains(cod);
            }

            // filtro por donante
            if (coincide && !don.isEmpty()) {
                coincide = d.getDonante() != null &&
                           d.getDonante().toLowerCase().contains(don);
            }

            if (coincide) {
                resultado.add(d);
            }
        }
        return resultado;
    }
}
