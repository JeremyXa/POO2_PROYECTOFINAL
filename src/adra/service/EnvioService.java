package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.observer.NotificationObserver;
import adra.repository.EnvioRepository;

import java.io.IOException;
import java.util.List;

public class EnvioService {

    private final EnvioRepository envioRepository;
    private final EnvioConstanciaFormatter formatter;
    private final NotificationObserver observer;

    public EnvioService(EnvioRepository envioRepository,
                        EnvioConstanciaFormatter formatter,
                        NotificationObserver observer) {
        this.envioRepository = envioRepository;
        this.formatter = formatter;
        this.observer = observer;
    }

    public ResultadoOperacion registrarEnvio(List<Donacion> donaciones,
                                             String destinatario,
                                             String destinoEnvio,
                                             String conductor) {

        if (donaciones == null || donaciones.isEmpty()) {
            return ResultadoOperacion.error("No hay donaciones seleccionadas para el envío.");
        }

        String constancia = formatter.generarConstancia(donaciones, destinatario, destinoEnvio, conductor);
        try {
            envioRepository.saveEnvio(constancia);
            notifyObserver("Envío registrado para destinatario: " + destinatario);
            return ResultadoOperacion.exito("Constancia generada y guardada correctamente.");
        } catch (IOException e) {
            notifyObserver("Error registrando envío: " + e.getMessage());
            return ResultadoOperacion.error("Error al generar la constancia de envío.");
        }
    }

    private void notifyObserver(String msg) {
        if (observer != null) {
            observer.notify(msg);
        }
    }
}
