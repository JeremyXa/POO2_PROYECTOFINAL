package adra.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerNotificationObserver implements NotificationObserver {

    private final Logger logger;

    // Constructor sin parámetros (lo usa DependencyBuilder)
    public LoggerNotificationObserver() {
        this(Logger.getLogger(LoggerNotificationObserver.class.getName()));
    }

    // Constructor opcional si quisieras inyectar otro logger
    public LoggerNotificationObserver(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void notificar(String mensaje) {
        logger.log(Level.INFO, mensaje);
    }
}
