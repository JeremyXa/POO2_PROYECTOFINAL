package adra.service;

import adra.model.Donacion;
import adra.observer.NotificacionObserver;
import adra.repository.DonacionRepository;
import adra.dto.ResultadoOperacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DonacionService {

    private final DonacionRepository repository;
    private final List<NotificacionObserver> observers = new ArrayList<>();

    public DonacionService(DonacionRepository repository) {
        this.repository = repository;
    }

    public void agregarObserver(NotificacionObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    private void notificar(String mensaje) {
        for (NotificacionObserver o : observers) {
            o.notificar(mensaje);
        }
    }

    public ResultadoOperacion guardar(Donacion donacion) {
        if (donacion == null) {
            return ResultadoOperacion.error("La donación es nula.");
        }
        repository.agregar(donacion);
        notificar("Se registró una nueva donación: " + donacion.getCodigo());
        return ResultadoOperacion.exito("Donación registrada correctamente.");
    }

    public Donacion buscarPorCodigo(String codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public List<Donacion> buscarPorDonante(String donante) {
        if (donante == null || donante.isBlank()) {
            return Collections.emptyList();
        }
        return repository.buscarPorDonante(donante);
    }

    public List<Donacion> obtenerTodas() {
        return repository.obtenerTodas();
    }

    public ResultadoOperacion actualizar(Donacion donacion) {
        if (donacion == null) {
            return ResultadoOperacion.error("La donación es nula.");
        }
        repository.actualizar(donacion);
        notificar("Se actualizó la donación: " + donacion.getCodigo());
        return ResultadoOperacion.exito("Donación actualizada correctamente.");
    }

    public ResultadoOperacion eliminarPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return ResultadoOperacion.error("Código inválido.");
        }
        repository.eliminarPorCodigo(codigo);
        notificar("Se eliminó la donación: " + codigo);
        return ResultadoOperacion.exito("Donación eliminada correctamente.");
    }

    public ResultadoOperacion guardarCambios() {
        repository.guardarCambios();
        return ResultadoOperacion.exito("Cambios de donaciones guardados en archivo.");
    }
}
