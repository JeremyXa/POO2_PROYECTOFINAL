package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Voluntario;
import adra.observer.NotificacionObserver;
import adra.repository.VoluntarioRepository;

import java.util.ArrayList;
import java.util.List;

public class VoluntarioService {

    private final VoluntarioRepository repository;
    private final List<NotificacionObserver> observers = new ArrayList<>();

    public VoluntarioService(VoluntarioRepository repository) {
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

    public ResultadoOperacion registrarVoluntario(Voluntario voluntario) {
        if (voluntario == null) {
            return ResultadoOperacion.error("El voluntario es nulo.");
        }
        repository.agregar(voluntario);
        notificar("Se registró voluntario: " + voluntario.getCodigo());
        return ResultadoOperacion.exito("Voluntario registrado y asignado correctamente.");
    }

    public ResultadoOperacion guardarCambios() {
        repository.guardarCambios();
        return ResultadoOperacion.exito("Cambios de voluntarios guardados en archivo.");
    }
}
