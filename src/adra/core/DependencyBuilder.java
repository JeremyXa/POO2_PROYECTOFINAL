package adra.core;

import adra.auth.AuthStrategy;
import adra.auth.EnvioAuthStrategy;
import adra.auth.RegistroAuthStrategy;
import adra.auth.VisualizacionAuthStrategy;
import adra.auth.VoluntarioSupervisorAuthStrategy;
import adra.factory.DonacionFactory;
import adra.observer.LoggerNotificacionObserver;
import adra.observer.NotificacionObserver;
import adra.repository.DonacionFileRepositoryAdapter;
import adra.repository.DonacionRepository;
import adra.repository.EnvioFileRepositoryAdapter;
import adra.repository.EnvioRepository;
import adra.repository.VoluntarioFileRepositoryAdapter;
import adra.repository.VoluntarioRepository;
import adra.service.DonacionService;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

public final class DependencyBuilder {

    private DependencyBuilder() {
        // Utility class
    }

    public static AdraController buildController() {
        // Ruta base en tu máquina (ajusta USUARIO si hace falta)
        String basePath = "C:\\\\Users\\\\USUARIO\\\\Documents\\\\PYPOOO2\\\\";
        String donacionesFile = basePath + "donaciones.txt";
        String voluntariosFile = basePath + "voluntarios.txt";
        String enviosFile = basePath + "envios.txt";

        DonacionRepository donacionRepository = new DonacionFileRepositoryAdapter(donacionesFile);
        VoluntarioRepository voluntarioRepository = new VoluntarioFileRepositoryAdapter(voluntariosFile);
        EnvioRepository envioRepository = new EnvioFileRepositoryAdapter(enviosFile);

        DonacionService donacionService = new DonacionService(donacionRepository);
        VoluntarioService voluntarioService = new VoluntarioService(voluntarioRepository);
        EnvioService envioService = new EnvioService(envioRepository);

        // Observer para logs
        NotificacionObserver loggerObserver = new LoggerNotificacionObserver();
        donacionService.agregarObserver(loggerObserver);
        voluntarioService.agregarObserver(loggerObserver);
        envioService.agregarObserver(loggerObserver);

        DonacionFactory donacionFactory = new DonacionFactory();
        AdraFacade facade = new AdraFacade(donacionService, voluntarioService, envioService, donacionFactory);

        // Estrategias de autenticación
        AuthStrategy registroAuth = new RegistroAuthStrategy();
        AuthStrategy visualizacionAuth = new VisualizacionAuthStrategy();
        AuthStrategy envioAuth = new EnvioAuthStrategy();
        AuthStrategy supervisorAuth = new VoluntarioSupervisorAuthStrategy();

        return new AdraController(facade, registroAuth, visualizacionAuth, envioAuth, supervisorAuth);
    }
}
