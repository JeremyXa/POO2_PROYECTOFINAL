package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Voluntario;
import adra.observer.NotificationObserver;
import adra.repository.VoluntarioRepository;

import java.io.IOException;

public class VoluntarioService {

    private final VoluntarioRepository repository;
    private final NotificationObserver observer;

    public VoluntarioService(VoluntarioRepository repository,
                             NotificationObserver observer) {
        this.repository = repository;
        this.observer = observer;
    }

    public ResultadoOperacion registrarVoluntario(String codigo,
                                                  String nombre,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {

        Voluntario v = new Voluntario(codigo, nombre, telefono, dni, edad, correo, tarea);
        try {
            repository.save(v);
            notifyObserver("Voluntario registrado: " + codigo);
            return ResultadoOperacion.exito("Voluntario registrado correctamente.");
        } catch (IOException e) {
            notifyObserver("Error registrando voluntario: " + e.getMessage());
            return ResultadoOperacion.error("Error al registrar el voluntario.");
        }
    }

    private void notifyObserver(String msg) {
        if (observer != null) {
            observer.notify(msg);
        }
    }
}
