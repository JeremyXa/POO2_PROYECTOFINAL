package adra.service;

import adra.dto.ResultadoOperacion;
import adra.factory.DonacionFactory;
import adra.model.Donacion;
import adra.observer.NotificationObserver;
import adra.repository.DonacionRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DonacionService {

    private final DonacionRepository repository;
    private final NotificationObserver observer;

    public DonacionService(DonacionRepository repository,
                           NotificationObserver observer) {
        this.repository = repository;
        this.observer = observer;
    }

    public ResultadoOperacion registrarDonacion(String codigo,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String donante) {
        Donacion d = DonacionFactory.crear(codigo, descripcion, fechaIngreso, cantidad, donante);
        try {
            repository.save(d);
            notifyObserver("Donación registrada: " + codigo);
            return ResultadoOperacion.exito("Donación registrada correctamente.");
        } catch (IOException e) {
            notifyObserver("Error registrando donación: " + e.getMessage());
            return ResultadoOperacion.error("Error al registrar la donación.");
        }
    }

    public List<Donacion> listarDonaciones() {
        try {
            return repository.findAll();
        } catch (IOException e) {
            notifyObserver("Error listando donaciones: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return listarDonaciones();
        }
        try {
            return repository.findByCodigo(codigo);
        } catch (IOException e) {
            notifyObserver("Error buscando por código: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) {
        if (donante == null || donante.isBlank()) {
            return listarDonaciones();
        }
        try {
            return repository.findByDonante(donante);
        } catch (IOException e) {
            notifyObserver("Error buscando por donante: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public ResultadoOperacion actualizarDonacion(Donacion donacion) {
        try {
            repository.update(donacion);
            notifyObserver("Donación actualizada: " + donacion.getCodigo());
            return ResultadoOperacion.exito("Donación actualizada correctamente.");
        } catch (IOException e) {
            notifyObserver("Error actualizando donación: " + e.getMessage());
            return ResultadoOperacion.error("Error al actualizar la donación.");
        }
    }

    public ResultadoOperacion eliminarDonacionPorCodigo(String codigo) {
        try {
            repository.deleteByCodigo(codigo);
            notifyObserver("Donación eliminada: " + codigo);
            return ResultadoOperacion.exito("Donación eliminada correctamente.");
        } catch (IOException e) {
            notifyObserver("Error eliminando donación: " + e.getMessage());
            return ResultadoOperacion.error("Error al eliminar la donación.");
        }
    }

    private void notifyObserver(String msg) {
        if (observer != null) {
            observer.notify(msg);
        }
    }
}
