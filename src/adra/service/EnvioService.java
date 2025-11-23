package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.model.Envio;
import adra.observer.NotificacionObserver;
import adra.repository.EnvioRepository;
import adra.util.EnvioConstanciaFormatter;

import java.util.ArrayList;
import java.util.List;

public class EnvioService {

    private final EnvioRepository repository;
    private final List<NotificacionObserver> observers = new ArrayList<>();

    public EnvioService(EnvioRepository repository) {
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

    public ResultadoOperacion registrarEnvio(String destinatario,
                                             String destino,
                                             String conductor,
                                             List<Donacion> donaciones) {
        if (destinatario == null || destinatario.isBlank()
                || destino == null || destino.isBlank()
                || conductor == null || conductor.isBlank()
                || donaciones == null || donaciones.isEmpty()) {
            return ResultadoOperacion.error("Datos de envío incompletos.");
        }

        Envio envio = new Envio(destinatario, destino, conductor, donaciones);
        String constancia = EnvioConstanciaFormatter.formatear(envio);
        repository.guardarConstancia(constancia);
        notificar("Se registró un envío con ID: " + envio.getId());

        return ResultadoOperacion.exito("Envío registrado y constancia generada.");
    }
}
