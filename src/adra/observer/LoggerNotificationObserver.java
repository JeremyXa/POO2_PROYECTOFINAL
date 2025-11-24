package adra.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de NotificationObserver que escribe los mensajes en un Logger.
 */
public class LoggerNotificationObserver implements NotificationObserver {

    private final Logger logger;

    // Constructor sin parámetros: usado por DependencyBuilder
    public LoggerNotificationObserver() {
        this(Logger.getLogger(LoggerNotificationObserver.class.getName()));
    }

    // Constructor con Logger inyectado (por si luego quieres otro logger)
    public LoggerNotificationObserver(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void notificar(String mensaje) {
        logger.log(Level.INFO, mensaje);
    }
}
