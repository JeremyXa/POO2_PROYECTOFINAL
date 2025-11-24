package adra.observer;

/**
 * Observador simple para registrar mensajes de notificación.
 */
public interface NotificationObserver {

    /**
     * Envía un mensaje de notificación.
     */
    void notificar(String mensaje);
}
