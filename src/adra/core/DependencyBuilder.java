package adra.core;

import adra.observer.LoggerNotificationObserver;
import adra.observer.NotificationObserver;
import adra.repository.DonacionFileRepositoryAdapter;
import adra.repository.DonacionRepository;
import adra.repository.EnvioFileRepositoryAdapter;
import adra.repository.EnvioRepository;
import adra.repository.VoluntarioFileRepositoryAdapter;
import adra.repository.VoluntarioRepository;
import adra.service.DonacionService;
import adra.service.EnvioConstanciaFormatter;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

public class DependencyBuilder {

    private static final String BASE_DIR = "C:\\Users\\USUARIO\\Documents\\PYPOOO2";
    private static final String DONACIONES_FILE   = BASE_DIR + "\\donaciones.txt";
    private static final String ENVIOS_FILE       = BASE_DIR + "\\envios.txt";
    private static final String VOLUNTARIOS_FILE  = BASE_DIR + "\\voluntarios.txt";
    private static final String CONSTANCIAS_FILE  = BASE_DIR + "\\constancias_envio.txt";

    private DependencyBuilder() {
    }

    public static AdraController buildController() {

        // -------- Repositorios ----------
        DonacionRepository donacionRepo =
                new DonacionFileRepositoryAdapter(DONACIONES_FILE);

        EnvioRepository envioRepo =
                new EnvioFileRepositoryAdapter(ENVIOS_FILE);

        VoluntarioRepository voluntarioRepo =
                new VoluntarioFileRepositoryAdapter(VOLUNTARIOS_FILE);

        // -------- Observer (logger global) ----------
        NotificationObserver observer = new LoggerNotificationObserver();

        // -------- Servicios ----------
        DonacionService donacionService =
                new DonacionService(donacionRepo, observer);

        EnvioConstanciaFormatter formatter =
                new EnvioConstanciaFormatter(CONSTANCIAS_FILE);

        EnvioService envioService =
                new EnvioService(envioRepo, formatter, observer);

        // Dejo VoluntarioService como tú lo tenías (solo con repositorio)
        VoluntarioService voluntarioService =
                new VoluntarioService(voluntarioRepo);

        // -------- Controller principal ----------
        return new AdraController(donacionService, envioService, voluntarioService);
    }
}
