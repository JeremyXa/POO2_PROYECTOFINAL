package adra.core;

import adra.observer.LoggerNotificationObserver;
import adra.observer.NotificationObserver;
import adra.repository.*;
import adra.service.*;

import java.util.logging.Logger;

public class DependencyBuilder {

    private DependencyBuilder() { }

    public static AdraController buildController() {

        // Logger / observer
        Logger logger = Logger.getLogger("ADRA");
        NotificationObserver observer = new LoggerNotificationObserver(logger);

        // Repositorios (ajusta las rutas a donde quieras guardar los TXT)
        DonacionRepository donacionRepo =
                new DonacionFileRepositoryAdapter("data/donaciones.txt");

        EnvioRepository envioRepo =
                new EnvioFileRepositoryAdapter("data/constancias_envio.txt");

        VoluntarioRepository voluntarioRepo =
                new VoluntarioFileRepositoryAdapter("data/voluntarios.txt");

        // Servicios
        DonacionService donacionService =
                new DonacionService(donacionRepo, observer);

        EnvioConstanciaFormatter formatter = new EnvioConstanciaFormatter();

        EnvioService envioService =
                new EnvioService(envioRepo, formatter, observer);

        VoluntarioService voluntarioService =
                new VoluntarioService(voluntarioRepo, observer);

        // Controller
        return new AdraController(donacionService, envioService, voluntarioService);
    }
}
