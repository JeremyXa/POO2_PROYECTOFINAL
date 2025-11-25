package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.observer.NotificationObserver;
import adra.repository.EnvioRepository;

import java.util.List;

public class EnvioService {

    private final EnvioRepository envioRepository;      // por ahora casi no se usa
    private final EnvioConstanciaFormatter formatter;   // genera el TXT
    private final NotificationObserver observer;        // para logs

    // === CONSTRUCTOR COHERENTE CON DependencyBuilder ===
    public EnvioService(EnvioRepository envioRepository,
                        EnvioConstanciaFormatter formatter,
                        NotificationObserver observer) {
        this.envioRepository = envioRepository;
        this.formatter = formatter;
        this.observer = observer;
    }

    /**
     * Genera la constancia de envío y la guarda en el TXT
     */
    public ResultadoOperacion registrarEnvio(List<Donacion> donaciones,
                                             String destinatario,
                                             String destinoEnvio,
                                             String conductor) {

        if (donaciones == null || donaciones.isEmpty()) {
            return ResultadoOperacion.error("No hay donaciones para enviar.");
        }

        try {
            // Generar y guardar constancia
            formatter.generarYGuardarConstancia(
                    donaciones, destinatario, destinoEnvio, conductor
            );

            if (observer != null) {
                observer.notificar("Constancia generada para " + destinatario);
            }

            return ResultadoOperacion.exito("Constancia generada y guardada en TXT.");
        } catch (Exception ex) {
            if (observer != null) {
                observer.notificar("Error al generar constancia: " + ex.getMessage());
            }
            return ResultadoOperacion.error("Error generando constancia: " + ex.getMessage());
        }
    }
}
