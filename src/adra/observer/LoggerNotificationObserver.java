package adra.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerNotificationObserver implements NotificationObserver {

    private final Logger logger;

    public LoggerNotificationObserver(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void notify(String message) {
        logger.log(Level.INFO, message);
    }
}
