package adra.repository;

import java.io.IOException;

public interface EnvioRepository {
    void saveEnvio(String constanciaTexto) throws IOException;
}
