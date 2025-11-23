package adra.observer;

import java.util.logging.Logger;

public class LoggerNotificacionObserver implements NotificacionObserver {

    private static final Logger logger = Logger.getLogger(LoggerNotificacionObserver.class.getName());

    @Override
    public void notificar(String mensaje) {
        logger.info(mensaje);
    }
}
